package com.mahedi.kidstube.util

/**
 * @author Mahedi Hassan
 * 2020-05-21
 */

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahedi.kidstube.R

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .centerCrop()
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}