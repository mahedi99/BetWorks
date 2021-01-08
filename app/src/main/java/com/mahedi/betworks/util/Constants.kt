package com.mahedi.betworks.util

/**
 * @author Mahedi Hassan
 * 2021-01-07
 */

interface Constants {
    companion object {
        const val USERNAME_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{2,}$"
        const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{2,}$"
        const val EMAIL_PROMPT = "Username"
        const val PASSWORD_PROMPT = "Password"
    }
}