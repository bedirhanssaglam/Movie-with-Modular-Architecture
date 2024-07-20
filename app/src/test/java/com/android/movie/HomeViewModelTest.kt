package com.android.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.android.data.repository.MovieRepositoryImpl
import com.android.model.Movie
import com.android.movie.ui.home.HomeViewModel
import com.android.test.MainCoroutinesRule
import com.android.test.TestUtil
import com.android.test.TestUtil.getOrAwaitValue
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    private lateinit var movieRepository: MovieRepositoryImpl

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(movieRepository)
    }

    @Test
    fun `getTopRatedMovies fetches movies and updates live data`() = runTest {
        val mockResponse = TestUtil.mockMovieResponse()
        val mockMovies = TestUtil.mockMovie()

        Mockito.`when`(movieRepository.fetchTopRatedMovies(1)).thenReturn(mockResponse)

        val observer = Observer<List<Movie>?> {}
        try {
            homeViewModel.movie.observeForever(observer)

            homeViewModel.getTopRatedMovies()

            assertThat(homeViewModel.movie.getOrAwaitValue(), `is`(mockMovies))
            assertFalse(homeViewModel.isLoading)
        } finally {
            homeViewModel.movie.removeObserver(observer)
        }
    }

    @Test
    fun `fetchMovies handles error scenario`() = runTest {
        Mockito.`when`(movieRepository.fetchTopRatedMovies(1)).thenReturn(null)

        val observer = Observer<List<Movie>?> {}
        try {
            homeViewModel.movie.observeForever(observer)

            homeViewModel.getTopRatedMovies()

            assertTrue(homeViewModel.isError)
            assertFalse(homeViewModel.isLoading)
        } finally {
            homeViewModel.movie.removeObserver(observer)
        }
    }

}


