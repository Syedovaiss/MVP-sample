package com.vend.mvpsample.features.photos.contracts

import com.vend.mvpsample.data.photo.Photos

/**
Created By Syed Ovais Akhtar On 3/13/21 6:02 PM2
 **/
interface PhotoContracts {

    interface View {

        fun onNetworkError(message: String?)
        fun onSuccess(data:Photos)

    }

    interface Presenter {
        fun getPhotos()
    }
}