package com.android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponse(
    val results: MutableList<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    val page: Int,
) : Serializable
