package com.mahedi.betworks.data.service

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import retrofit2.http.*
import java.io.IOException

/**
 * @author Mahedi Hassan
 * 2021-01-06
 */

class MockInterceptor : Interceptor {
    private val responseString = "{\"isSuccessful\":true,\"username\":\"JOHN DOE\"}"
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
//        addDelay()
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .body(
                ResponseBody.create(
                    "application/json".toMediaTypeOrNull(),
                    responseString.toByteArray()
                )
            )
            .addHeader("content-type", "application/json")
            .build()
    }

    private fun addDelay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}