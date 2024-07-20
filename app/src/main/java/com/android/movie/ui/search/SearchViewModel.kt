package com.android.movie.ui.search

import com.android.data.repository.MovieRepositoryImpl
import com.android.movie.base.viewmodel.BaseMovieViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    movieRepository: MovieRepositoryImpl
) : BaseMovieViewModel(movieRepository) {

    private var newSearchQuery: String? = null
    private var oldSearchQuery: String? = null

    fun getSearchedMovies(searchQuery: String) {
        newSearchQuery = searchQuery
        if (newSearchQuery != oldSearchQuery) {
            moviesPage = 1
            oldSearchQuery = newSearchQuery
            movieResponse = null
        }

        fetchMovies { page ->
            movieRepository.fetchSearchedMovies(searchQuery, page)
        }
    }
}
