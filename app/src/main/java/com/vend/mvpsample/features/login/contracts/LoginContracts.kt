package com.vend.mvpsample.features.login.contracts

import com.vend.mvpsample.features.login.model.User

/**
Created By Syed Ovais Akhtar On 3/13/21 6:08 PM2
 **/
interface LoginContracts {

    interface View {

        fun onSuccessfulLogin()
        fun onEmptyUsername()
        fun onEmptyPassword()
        fun onInvalidCredentials()
    }

    interface Presenter {
        fun onLogin(user: User)
    }
}