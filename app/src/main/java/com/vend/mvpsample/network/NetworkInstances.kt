package com.vend.mvpsample.network

import com.vend.mvpsample.apiservices.PhotoAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
Created By Syed Ovais Akhtar On 3/13/21 5:54 PM2
 **/
class NetworkInstances {

    companion object {

        fun getInstance(): PhotoAPIService? {
            val builder = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return builder.create(PhotoAPIService::class.java)

        }
    }
}