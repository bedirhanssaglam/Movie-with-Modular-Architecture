package com.android.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.android.data.repository.MovieRepositoryImpl
import com.android.model.category.Category
import com.android.movie.ui.category.CategoryViewModel
import com.android.test.MainCoroutinesRule
import com.android.test.TestUtil
import com.android.test.TestUtil.getOrAwaitValue
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CategoryViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    private lateinit var movieRepository: MovieRepositoryImpl

    private lateinit var categoryViewModel: CategoryViewModel

    @Before
    fun setUp() {
        categoryViewModel = CategoryViewModel(movieRepository)
    }

    @Test
    fun `fetchCategories fetches categories and updates live data`() = runTest {
        val mockResponse = TestUtil.mockCategoryResponse()
        val mockCategory = TestUtil.mockCategory()

        Mockito.`when`(movieRepository.fetchAllCategories()).thenReturn(mockResponse)

        val observer = Observer<List<Category>?> {}
        try {
            categoryViewModel.categories.observeForever(observer)

            categoryViewModel.fetchCategories()

            assertThat(categoryViewModel.categories.getOrAwaitValue(), `is`(mockCategory))
            assertFalse(categoryViewModel.isLoading)
        } finally {
            categoryViewModel.categories.removeObserver(observer)
        }
    }
}


