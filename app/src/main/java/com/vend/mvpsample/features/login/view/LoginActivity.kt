package com.vend.mvpsample.features.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vend.mvpsample.R
import com.vend.mvpsample.databinding.ActivityLoginBinding
import com.vend.mvpsample.features.login.contracts.LoginContracts
import com.vend.mvpsample.features.login.model.User
import com.vend.mvpsample.features.login.presenter.LoginPresenter
import com.vend.mvpsample.features.photos.view.PhotoActivity
import com.vend.mvpsample.utils.displayToast
import com.vend.mvpsample.utils.moveActivity

class LoginActivity : AppCompatActivity(), LoginContracts.View {

    private lateinit var presenter: LoginPresenter
    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        presenter = LoginPresenter(this)

        binding?.button?.setOnClickListener {
            val username = binding?.username?.text.toString()
            val password = binding?.password?.text.toString()
            presenter.onLogin(User(username, password))

        }
    }

    override fun onSuccessfulLogin() {

        this.displayToast(getString(R.string.logged_in))
        this.moveActivity(PhotoActivity::class.java)
    }

    override fun onEmptyUsername() {
        this.displayToast(getString(R.string.on_empty, "Username"))

    }

    override fun onEmptyPassword() {
        this.displayToast(getString(R.string.on_empty, "Password"))
    }

    override fun onInvalidCredentials() {
        this.displayToast(getString(R.string.invalid_cred))
    }


}