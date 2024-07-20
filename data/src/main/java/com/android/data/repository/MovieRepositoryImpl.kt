package com.android.data.repository

import com.android.model.MovieResponse
import com.android.model.category.CategoryResponse
import com.android.network.utils.Dispatcher
import com.android.network.utils.MovieAppDispatchers
import com.android.network.service.MovieClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieClient: MovieClient,
    @Dispatcher(MovieAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : MovieRepository {

    override suspend fun fetchTopRatedMovies(page: Int): MovieResponse? {
        return withContext(ioDispatcher) {
            try {
                val response: Response<MovieResponse>? = movieClient.fetchTopRatedMovies(page = page)
                if (response?.isSuccessful == true) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }

    override suspend fun fetchSearchedMovies(query: String, page: Int): MovieResponse? {
        return withContext(ioDispatcher) {
            try {
                val response: Response<MovieResponse>? = movieClient.fetchSearchedMovies(query = query, page = page)
                if (response?.isSuccessful == true) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }

    override suspend fun fetchAllCategories(): CategoryResponse? {
        return withContext(ioDispatcher) {
            try {
                val response: Response<CategoryResponse>? = movieClient.fetchAllCategories()
                if (response?.isSuccessful == true) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}