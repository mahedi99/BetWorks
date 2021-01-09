package com.mahedi.betworks.data.model

import org.junit.Assert.*
import org.junit.Test

class LoggedInUserTest {
    private lateinit var loggedInUser: LoggedInUser

    @Test
    fun `insert data confirmed test`() {
        loggedInUser = LoggedInUser(isSuccessful = false)
        assertNotNull(loggedInUser)
        assertFalse(loggedInUser.isSuccessful)
    }
}