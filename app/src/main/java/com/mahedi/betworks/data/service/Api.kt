package com.mahedi.betworks.data.service

import com.mahedi.betworks.data.model.LoggedInUser
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * @author Mahedi Hassan
 * 2021-01-06
 */

interface Api {

    @POST("/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<LoggedInUser>

    companion object {
        private var retrofitInstance: Retrofit? = null
        private var instance: Api? = null

        private fun getRetrofitInstance(): Retrofit {
            return retrofitInstance ?: synchronized(this) {
                val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(MockInterceptor())
                    .build()
                val tempInstance = Retrofit.Builder()
                    .baseUrl("http://www.mock.com/login/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                retrofitInstance = tempInstance
                tempInstance
            }
        }

        fun getInstance(): Api {
            return instance ?: synchronized(this) {
                val tempInstance = getRetrofitInstance().create(Api::class.java)
                instance = tempInstance
                tempInstance
            }
        }
    }
}