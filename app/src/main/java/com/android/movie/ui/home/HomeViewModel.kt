package com.android.movie.ui.home

import com.android.data.repository.MovieRepositoryImpl
import com.android.movie.base.viewmodel.BaseMovieViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    movieRepository: MovieRepositoryImpl
) : BaseMovieViewModel(movieRepository) {

    init {
        getTopRatedMovies()
    }

    fun getTopRatedMovies() {
        fetchMovies { page ->
            movieRepository.fetchTopRatedMovies(page)
        }
    }
}
