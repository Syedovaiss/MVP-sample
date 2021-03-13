package com.vend.mvpsample.features.login.presenter

import com.vend.mvpsample.features.login.contracts.LoginContracts
import com.vend.mvpsample.features.login.model.User

/**
Created By Syed Ovais Akhtar On 3/13/21 6:10 PM2
 **/
class LoginPresenter(private val view: LoginContracts.View) : LoginContracts.Presenter {

    private val userAuth = User("talha", "12345")

    override fun onLogin(user: User) {

        if (user.username.isEmpty()) {
            view.onEmptyUsername()
        } else if (user.password.isEmpty()) {
            view.onEmptyPassword()
        } else if (user.username == userAuth.username && user.password == userAuth.password) {
            view.onSuccessfulLogin()
        } else {
            view.onInvalidCredentials()
        }


    }


}