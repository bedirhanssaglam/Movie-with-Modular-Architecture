package com.android.movie.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.model.Movie
import com.android.movie.databinding.ActivityMovieDetailBinding
import com.android.movie.utils.PageParams
import com.android.movie.utils.getSerializableData

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getSerializableData<Movie>(PageParams.MOVIE.reference)
        binding.movie = movie

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
