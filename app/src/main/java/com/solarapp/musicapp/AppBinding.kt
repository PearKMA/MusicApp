package com.solarapp.musicapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object AppBinding{
    @JvmStatic
    @BindingAdapter("setImagePath")
    fun setImagePath(im: ImageView, path: String){
        Glide.with(im)
            .load(path)
            .centerCrop()
            .into(im)
    }
}