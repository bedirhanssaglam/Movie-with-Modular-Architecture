package com.android.network.service

import com.android.model.MovieResponse
import com.android.model.category.CategoryResponse
import com.android.network.BuildConfig
import com.android.network.utils.NetworkConstants
import com.android.network.utils.NetworkConstants.API_KEY
import com.android.network.utils.NetworkConstants.DEFAULT_PAGE_VALUE
import com.android.network.utils.NetworkConstants.PAGE
import com.android.network.utils.NetworkConstants.QUERY
import com.android.network.utils.NetworkConstants.SEARCHED_MOVIE_PATH
import com.android.network.utils.NetworkConstants.TOP_RATED_PATH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(TOP_RATED_PATH)
    suspend fun fetchTopRatedMovies(
        @Query(API_KEY) apiKey: String = BuildConfig.API_KEY,
        @Query(PAGE) page: Int = DEFAULT_PAGE_VALUE,
    ): Response<MovieResponse>?

    @GET(SEARCHED_MOVIE_PATH)
    suspend fun fetchSearchedMovies(
        @Query(API_KEY) apiKey: String = BuildConfig.API_KEY,
        @Query(PAGE) page: Int = DEFAULT_PAGE_VALUE,
        @Query(QUERY) query: String = "",
    ): Response<MovieResponse>?

    @GET(NetworkConstants.CATEGORIES_PATH)
    suspend fun fetchAllCategories(
        @Query(API_KEY) apiKey: String = BuildConfig.API_KEY,
    ): Response<CategoryResponse>?
}