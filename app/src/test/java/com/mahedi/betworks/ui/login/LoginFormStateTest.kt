package com.mahedi.betworks.ui.login

import com.mahedi.betworks.R
import org.junit.Assert.*
import org.junit.Test

class LoginFormStateTest {
    private lateinit var loginFormState: LoginFormState

    @Test
    fun `insert data confirmed test`() {
        loginFormState = LoginFormState(usernameError = R.string.invalid_username)
        assertNotNull(loginFormState)
        assertFalse(loginFormState.isDataValid)
        assertNull(loginFormState.passwordError)
        assertEquals(loginFormState.usernameError, R.string.invalid_username)
    }

}