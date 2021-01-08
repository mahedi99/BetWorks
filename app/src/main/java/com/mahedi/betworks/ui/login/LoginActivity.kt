package com.mahedi.betworks.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.betworks.R
import com.mahedi.betworks.data.model.ChildLoginViewObj
import com.mahedi.betworks.data.model.ParentLoginViewObj
import com.mahedi.betworks.ui.welcome.WelcomeActivity
import com.mahedi.betworks.util.Constants

class LoginActivity : AppCompatActivity(), LoginViewModel.LoginViewCallBack,
    LoginAdapter.LoginListener {

    private lateinit var adapter: LoginAdapter
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initRecyclerView()
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = LoginAdapter(
            this,
            this,
            listOf(
                ChildLoginViewObj(prompt = Constants.EMAIL_PROMPT),
                ChildLoginViewObj(prompt = Constants.PASSWORD_PROMPT),
                ParentLoginViewObj()
            )
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onFinishLogin() {
        setResult(Activity.RESULT_OK)
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }

    override fun onButtonClick(username: String, password: String) {
        loginViewModel.login(username, password)
    }
}