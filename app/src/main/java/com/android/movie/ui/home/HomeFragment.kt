package com.android.movie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.movie.MainActivity
import com.android.movie.R
import com.android.movie.base.fragment.BaseMovieFragment
import com.android.movie.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseMovieFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()
    override lateinit var binding: FragmentHomeBinding

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun observeViewModel() {
        viewModel.movie.observe(viewLifecycleOwner) {
            it?.let {
                movieAdapter.differ.submitList(it.toList())
            }
        }
    }

    override fun loadMoreMovies() {
        viewModel.getTopRatedMovies()
    }

    override fun getRecyclerViewId(): Int = R.id.topRatedMovieRecycler
}
