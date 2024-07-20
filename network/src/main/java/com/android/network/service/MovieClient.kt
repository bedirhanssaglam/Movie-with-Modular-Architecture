package com.android.network.service

import com.android.model.MovieResponse
import com.android.model.category.CategoryResponse
import retrofit2.Response
import javax.inject.Inject

class MovieClient @Inject constructor(
    private val movieService: MovieService,
) {
    suspend fun fetchTopRatedMovies(page: Int): Response<MovieResponse>? =
        movieService.fetchTopRatedMovies(page = page)

    suspend fun fetchSearchedMovies(query: String, page: Int): Response<MovieResponse>? =
        movieService.fetchSearchedMovies(query = query, page = page)

    suspend fun fetchAllCategories(): Response<CategoryResponse>? =
        movieService.fetchAllCategories()
}