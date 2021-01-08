package com.mahedi.betworks.ui.login

import androidx.databinding.ObservableField

/**
 * User details post authentication that is exposed to the UI
 */
class LoggedInUserView {
    val username = ObservableField<String>()

    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: LoggedInUserView? = null

        @JvmStatic
        fun getInstance(): LoggedInUserView =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: LoggedInUserView().also { INSTANCE = it }
            }
    }
}