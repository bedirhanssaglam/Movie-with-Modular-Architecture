package com.android.movie.base.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.data.repository.MovieRepositoryImpl
import com.android.model.Movie
import com.android.model.MovieResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseMovieViewModel @Inject constructor(
    val movieRepository: MovieRepositoryImpl
) : ObservableViewModel() {

    protected var moviesPage = 1
    protected var movieResponse: MovieResponse? = null

    private val _movie = MutableLiveData<List<Movie>?>()
    val movie: LiveData<List<Movie>?> = _movie

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        protected set

    @get:Bindable
    var isError: Boolean by bindingProperty(false)
        protected set

    @get:Bindable
    var isLastPage: Boolean by bindingProperty(false)
        protected set

    protected fun fetchMovies(fetchMoviesFunc: suspend (Int) -> MovieResponse?) {
        if (isLoading || isLastPage) return

        isLoading = true
        viewModelScope.launch {
            try {
                val response = fetchMoviesFunc(moviesPage)
                response?.let {
                    if (movieResponse == null) {
                        movieResponse = response
                    } else {
                        movieResponse?.results?.addAll(response.results)
                    }
                    _movie.value = movieResponse?.results
                    moviesPage++
                    if (response.results.isEmpty()) isLastPage = true
                } ?: run {
                    isError = true
                }
            } catch (e: Exception) {
                isError = true
            } finally {
                isLoading = false
            }
        }
    }
}
