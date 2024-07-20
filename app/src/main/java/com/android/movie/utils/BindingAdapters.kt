package com.android.movie.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("app:goneUnless")
    @JvmStatic
    fun goneUnless(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter("android:downloadUrl")
    @JvmStatic
    fun downloadUrl(view: ImageView, url: String?) {
        view.downloadFromUrl("${AppConstants.BASE_URL_FOR_IMAGE}$url")
    }
}
