package com.mahedi.betworks.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
        val isSuccessful: Boolean,
        val username: String = ""
)