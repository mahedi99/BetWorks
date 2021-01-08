package com.mahedi.betworks.ui.login

import androidx.lifecycle.ViewModel
import com.mahedi.betworks.data.service.LoginRepository
import io.reactivex.MaybeObserver
import io.reactivex.disposables.Disposable

class LoginViewModel(private val loginRepository: LoginRepository, val loginActivity: LoginActivity) : ViewModel() {

    fun login(username: String, password: String) {
        loginRepository.login(username, password).subscribe(LoginObserver())
    }

    private fun onLoginComplete() {
        loginActivity.onFinishLogin()
    }

    inner class LoginObserver : MaybeObserver<Any> {
        override fun onSubscribe(d: Disposable) {}
        override fun onSuccess(t: Any) {
            onLoginComplete()
        }
        override fun onError(e: Throwable) {
        }
        override fun onComplete() {
        }
    }

    interface LoginViewCallBack {
        fun onFinishLogin()
    }
}