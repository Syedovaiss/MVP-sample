package com.vend.mvpsample.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
Created By Syed Ovais Akhtar On 3/13/21 6:26 PM2
 **/

fun Context.displayToast(message: String) {

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T> Context.moveActivity(clazz: Class<T>){
    Intent(this,clazz).also {
        startActivity(it)
    }
}