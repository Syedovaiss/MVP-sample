package com.vend.mvpsample.apiservices

import com.vend.mvpsample.data.photo.Photos
import retrofit2.Call
import retrofit2.http.GET

/**
Created By Syed Ovais Akhtar On 3/13/21 5:56 PM2
 **/
interface PhotoAPIService {

    @GET("photos")
    fun getPhotos(): Call<Photos>
}