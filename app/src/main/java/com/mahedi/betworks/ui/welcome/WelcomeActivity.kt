package com.mahedi.betworks.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mahedi.betworks.R
import com.mahedi.betworks.ui.login.LoggedInUserView
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val userName = findViewById<TextView>(R.id.usernameTextView)
        userName.text = LoggedInUserView.getInstance().username.get()
    }
}