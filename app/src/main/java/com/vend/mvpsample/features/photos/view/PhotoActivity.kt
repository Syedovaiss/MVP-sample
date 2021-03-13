package com.vend.mvpsample.features.photos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vend.mvpsample.R
import com.vend.mvpsample.data.photo.Photos
import com.vend.mvpsample.databinding.ActivityPhotoBinding
import com.vend.mvpsample.features.photos.adapter.PhotoAdapter
import com.vend.mvpsample.features.photos.contracts.PhotoContracts
import com.vend.mvpsample.features.photos.presenter.PhotoPresenter
import com.vend.mvpsample.utils.displayToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoActivity : AppCompatActivity(), PhotoContracts.View {

    private lateinit var presenter: PhotoPresenter
    private var binding: ActivityPhotoBinding? = null
    private lateinit var photoAdapter: PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo)
        presenter = PhotoPresenter(this)
        getPhotos()
        photoAdapter = PhotoAdapter()

    }

    private fun getPhotos() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                presenter.getPhotos()
            }
        }
    }

    override fun onNetworkError(message: String?) {
        this.displayToast(message!!)
    }

    override fun onSuccess(data: Photos) {
        photoAdapter.addPhotos(data)
        binding?.recyclerView?.also {
            it.adapter = photoAdapter
            it.layoutManager = LinearLayoutManager(this)
        }

    }
}