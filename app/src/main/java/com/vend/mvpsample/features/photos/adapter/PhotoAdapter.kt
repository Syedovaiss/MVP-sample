package com.vend.mvpsample.features.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vend.mvpsample.R
import com.vend.mvpsample.data.photo.PhotosItem
import com.vend.mvpsample.databinding.ItemRowsBinding

/**
Created By Syed Ovais Akhtar On 3/13/21 6:02 PM2
 **/

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photos = ArrayList<PhotosItem>()

    fun addPhotos(photoData: ArrayList<PhotosItem>) {
        this.photos = photoData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoAdapter.PhotoViewHolder {
        val view: ItemRowsBinding =
            ItemRowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
        val items = photos[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int = photos.size

    inner class PhotoViewHolder(private val itemRowsBinding: ItemRowsBinding) : RecyclerView.ViewHolder(itemRowsBinding.root) {

        fun bind(photos: PhotosItem) {

            Glide.with(itemRowsBinding.root)
                .load(photos.url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemRowsBinding.thumbnail)


        }
    }
}