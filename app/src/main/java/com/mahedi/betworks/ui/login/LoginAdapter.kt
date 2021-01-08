package com.mahedi.betworks.ui.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.betworks.R
import com.mahedi.betworks.data.model.ChildLoginViewObj
import com.mahedi.betworks.data.model.HasType
import com.mahedi.betworks.data.model.ParentLoginViewObj
import com.mahedi.betworks.data.model.ViewType
import com.mahedi.betworks.util.Constants
import com.mahedi.betworks.util.afterTextChanged
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Mahedi Hassan
 * 2021-01-07
 */

class LoginAdapter internal constructor(
    context: Context,
    val loginListener: LoginListener,
    private val dataList: List<HasType>
) : RecyclerView.Adapter<BaseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    /**
     * The View Holder class is to render each item for the inner recyclerview. This class
     * is inherited from [RecyclerView.ViewHolder]
     */
    inner class InputViewHolder(itemView: View) : BaseViewHolder(itemView){
        private val inputView: EditText = itemView.findViewById(R.id.input)
        override fun bind(data: HasType, position: Int) {
            val tmpData = data as ChildLoginViewObj
            inputView.hint = tmpData.prompt

            inputView.afterTextChanged {
                tmpData.data = inputView.text.toString()
                val username = dataList[0] as ChildLoginViewObj
                val password = dataList[1] as ChildLoginViewObj
                val login = dataList[2] as ParentLoginViewObj

                val loginState = loginDataChanged(username.data, password.data)
                login.isEnabled = loginState.isDataValid

                notifyItemChanged(2)
            }
        }
    }
    inner class LoginViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val loginView: Button = itemView.findViewById(R.id.login)
        override fun bind(data: HasType, position: Int) {
            val tmpData = data as ParentLoginViewObj
            loginView.isEnabled = tmpData.isEnabled
            loginView.setOnClickListener {
                val username = dataList[0] as ChildLoginViewObj
                val password = dataList[1] as ChildLoginViewObj
                loginListener.onButtonClick(username.data, password.data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            ViewType.CHILD.type -> InputViewHolder(inflater.inflate(R.layout.layout_input, parent, false))
            ViewType.PARENT.type -> LoginViewHolder(inflater.inflate(R.layout.layout_login, parent, false))
            else -> throw IllegalArgumentException("invalid type of adapter")
        }
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].getType()
    }

    override fun getItemCount() = dataList.size

    fun loginDataChanged(username: String, password: String): LoginFormState {
        return if (!isUserNameValid(username)) {
            LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            LoginFormState(passwordError = R.string.invalid_password)
        } else {
            LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        val pattern: Pattern =
            Pattern.compile(Constants.PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(username)
        return matcher.matches()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        val pattern: Pattern =
            Pattern.compile(Constants.PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    interface LoginListener {
        fun onButtonClick(username: String, password: String)
    }
}