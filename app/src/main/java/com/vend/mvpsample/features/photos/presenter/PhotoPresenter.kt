package com.vend.mvpsample.features.photos.presenter

import com.vend.mvpsample.data.photo.Photos
import com.vend.mvpsample.features.photos.contracts.PhotoContracts
import com.vend.mvpsample.network.NetworkInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
Created By Syed Ovais Akhtar On 3/13/21 5:59 PM2
 **/
class PhotoPresenter(private val view: PhotoContracts.View) : PhotoContracts.Presenter {

    private val retrofit = NetworkInstances.getInstance()

    override fun getPhotos() {

        retrofit?.getPhotos()?.enqueue(object : Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                if (response.isSuccessful) {
                    view.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                view.onNetworkError(t.message)
            }
        })
    }
}