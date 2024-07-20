package com.android.movie.base.fragment

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.android.movie.ui.detail.MovieDetailActivity
import com.android.movie.base.listener.RecyclerViewScrollListener
import com.android.movie.ui.home.MovieAdapter
import com.android.movie.utils.PageParams
import timber.log.Timber

abstract class BaseMovieFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {

    protected abstract val viewModel: VM
    protected abstract var binding: VB

    protected lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView

    protected abstract fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): VB

    protected abstract fun observeViewModel()

    protected abstract fun loadMoreMovies()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = inflateBinding(inflater, container)
        Timber.d("Binding inflated")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMovieRecyclerView()

        movieAdapter.setOnItemClickListener {
            val intent = Intent(requireContext(), MovieDetailActivity::class.java)
            intent.putExtra(PageParams.MOVIE.reference, it)
            startActivity(intent)
        }

        observeViewModel()
        Timber.d("View created and ViewModel observed")
    }

    private fun setupMovieRecyclerView() {
        movieAdapter = MovieAdapter()
        val layoutManager = LinearLayoutManager(activity)

        recyclerView = binding.root.findViewById<RecyclerView>(getRecyclerViewId()).apply {
            adapter = movieAdapter
            this.layoutManager = layoutManager
            addOnScrollListener(object : RecyclerViewScrollListener(layoutManager) {
                override fun onLoadMore() {
                    Timber.d("Load more triggered")
                    loadMoreMovies()
                }
            })
        }
        Timber.d("RecyclerView setup complete")
    }

    protected abstract fun getRecyclerViewId(): Int
}
