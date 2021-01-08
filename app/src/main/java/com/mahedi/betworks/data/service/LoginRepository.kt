package com.mahedi.betworks.data.service

import android.util.Log
import com.mahedi.betworks.data.model.LoggedInUser
import com.mahedi.betworks.ui.login.LoggedInUserView
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.security.auth.login.LoginException

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository {

    private var isRequestingLogin = false

    fun isRequestingLogin(): Boolean {
        return isRequestingLogin
    }

    fun login(username: String, password: String): Maybe<LoggedInUser> {
        return Api.getInstance().login(username, password)
            .doOnSubscribe { isRequestingLogin = true }
            .doOnTerminate { isRequestingLogin = false }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext(this::handleLoginError)
            .doOnNext(this::processLoginResponse)
            .singleElement()
    }

    private fun handleLoginError(throwable: Throwable): Observable<LoggedInUser> {
        Log.e("Login Error", throwable.message.toString())
        throw LoginException()
    }

    private fun processLoginResponse(loginResponse: LoggedInUser) {
        LoggedInUserView.getInstance().username.set(loginResponse.username)
    }
}