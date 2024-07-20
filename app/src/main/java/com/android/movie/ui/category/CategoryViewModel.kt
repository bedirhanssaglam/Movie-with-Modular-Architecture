package com.android.movie.ui.category

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.data.repository.MovieRepositoryImpl
import com.android.model.category.Category
import com.android.movie.base.viewmodel.ObservableViewModel
import com.android.movie.base.viewmodel.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val movieRepository: MovieRepositoryImpl) : ObservableViewModel() {
    private val _categories = MutableLiveData<List<Category>?>()
    val categories: LiveData<List<Category>?> = _categories

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)

    @get:Bindable
    var isError: Boolean by bindingProperty(false)

    init {
        fetchCategories()
    }

     fun fetchCategories() {
        isLoading = true
        viewModelScope.launch {
            try {
                val response = movieRepository.fetchAllCategories()
                response?.let {
                    _categories.value = response.genres
                }
            } catch (e: Exception) {
                isError = true
            } finally {
                isLoading = false
            }
        }
    }
}