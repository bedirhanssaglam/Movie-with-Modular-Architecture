package com.android.movie.utils

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.android.movie.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.downloadFromUrl(url: String?) {
    val options = RequestOptions()
        .transform(RoundedCorners(12))
        .placeholder(
            CircularProgressDrawable(context).apply {
                strokeWidth = 8f
                centerRadius = 40f
                start()
            }
        )
        .error(R.drawable.ic_error)

    Glide.with(context)
        .load(url)
        .apply(options)
        .into(this)
}

