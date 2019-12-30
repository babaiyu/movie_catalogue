package com.example.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_detail.view.*

class MovieDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieTitle: TextView = findViewById(R.id.movie_title)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie
        movieTitle.text = movie.title
    }
}
