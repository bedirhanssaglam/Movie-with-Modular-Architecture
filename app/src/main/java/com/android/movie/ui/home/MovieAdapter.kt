package com.android.movie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.model.Movie
import androidx.recyclerview.widget.AsyncListDiffer
import com.android.movie.R
import com.android.movie.databinding.MovieCardItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.HomeMovieViewHolder>() {
    inner class HomeMovieViewHolder(private val binding: MovieCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                binding.movie = movie

                // Set click listener to trigger the item click callback
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(movie) }
                }
            }
        }
    }

    /**
     * Inflates the item view and creates a ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: MovieCardItemBinding = DataBindingUtil.inflate(inflater, R.layout.movie_card_item, parent, false)
        return HomeMovieViewHolder(view)
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount(): Int = differ.currentList.size

    /**
     * Binds the data to the ViewHolder at the specified position.
     */
    override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    // Listener for item click events
    private var onItemClickListener: ((Movie) -> Unit)? = null

    /**
     * Sets the item click listener.
     *
     * @param listener The callback to be invoked on item click
     */
    fun setOnItemClickListener(listener: (Movie) -> Unit) {
        onItemClickListener = listener
    }

    // DiffUtil callback for comparing old and new items in the list
    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
        }
    }

    // AsyncListDiffer to handle list updates asynchronously
    val differ = AsyncListDiffer(this, differCallback)
}