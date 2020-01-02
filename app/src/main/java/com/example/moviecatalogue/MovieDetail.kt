package com.example.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_MOVIE = "extra_movie" // Initialize intent data name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie // Get selected movie with Intent getParcelableExtra
        title = movie.title
        movie_title.text = movie.title
        movie_release.text = movie.release
        movie_description?.text = movie.description
        movie_score?.text = movie.score
        movie_caster?.text = movie.caster
        movie_director?.text = movie.director
        Glide.with(movie_img)
            .load(movie.photo)
            .into(movie_img)

        feature_title?.text = movie.title
        feature_director?.text = movie.director
        feature_release?.text = movie.release

        btn_like.setOnClickListener {
            Toast.makeText(this, "You like ${movie.title} movie", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onClick(view: View?) {
    }
}
