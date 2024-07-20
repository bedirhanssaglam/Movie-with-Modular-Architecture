package com.android.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.android.model.Movie
import com.android.model.MovieResponse
import com.android.model.category.Category
import com.android.model.category.CategoryResponse
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

object TestUtil {

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(value: T) {
                data = value
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }

    fun mockMovieResponse() = MovieResponse(
        page = 1,
        results = mutableListOf(
            Movie(
                overview = "overview",
                voteCount = 10,
                posterPath = "posterPath",
                releaseDate = "20.10.2000",
                voteAverage = 8.9,
                id = 1,
                adult = false,
                backdropPath = "backdropPath",
                title = "title",
                popularity = 6.7,
                originalLanguage = "tr"
            ),
        ),
        totalResults = 1,
        totalPages = 1,

        )

    fun mockMovie(): List<Movie> = mutableListOf(
        Movie(
            overview = "overview",
            voteCount = 10,
            posterPath = "posterPath",
            releaseDate = "20.10.2000",
            voteAverage = 8.9,
            id = 1,
            adult = false,
            backdropPath = "backdropPath",
            title = "title",
            popularity = 6.7,
            originalLanguage = "tr"
        ),
    )

    fun mockCategoryResponse(): CategoryResponse = CategoryResponse(
        mutableListOf(
            Category(
                id = 28,
                name = "Action"
            )
        )
    )

    fun mockCategory(): List<Category> = mutableListOf(
        Category(
            id = 28,
            name = "Action"
        )
    )
}