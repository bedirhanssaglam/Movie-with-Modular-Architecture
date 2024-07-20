package com.android.data.repository

import com.android.model.MovieResponse
import com.android.model.category.CategoryResponse

interface MovieRepository {
    suspend fun fetchTopRatedMovies(page : Int): MovieResponse?
    suspend fun fetchSearchedMovies(query: String, page : Int): MovieResponse?
    suspend fun fetchAllCategories(): CategoryResponse?
}