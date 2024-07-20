package com.android.movie.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.android.movie.R
import com.android.movie.base.fragment.BaseMovieFragment
import com.android.movie.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseMovieFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModels()
    override lateinit var binding: FragmentSearchBinding

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false).apply {
            viewModel = this@SearchFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun observeViewModel() {
        viewModel.movie.observe(viewLifecycleOwner) {
            it?.let {
                movieAdapter.differ.submitList(it.toList())
            }
        }

        binding.searchEdit.addTextChangedListener { editable ->
            editable?.let {
                if (editable.toString().isNotEmpty()) {
                    viewModel.getSearchedMovies(editable.toString())
                }
            }
        }
    }

    override fun loadMoreMovies() {
        viewModel.getSearchedMovies(binding.searchEdit.text.toString())
    }

    override fun getRecyclerViewId(): Int = R.id.searchedMovieRecycler
}
