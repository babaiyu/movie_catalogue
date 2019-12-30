package com.example.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataRelease: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataScore: Array<String>
    private lateinit var dataCaster: Array<String>
    private lateinit var dataDirector: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()
    private var titleBar: String = "Movie Catalogue"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = titleBar

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, index, _ ->
            val moveMovie = Movie(
                movies[index].title,
                movies[index].release,
                movies[index].description,
                movies[index].score,
                movies[index].caster,
                movies[index].director,
                movies[index].photo
            )
            val moveMovieIntent = Intent(this@MainActivity, MovieDetail::class.java)
            moveMovieIntent.putExtra(MovieDetail.EXTRA_MOVIE, moveMovie)
            startActivity(moveMovieIntent)
        }
    }

    private fun addItem() {
        for (index in dataTitle.indices) {
            val movie = Movie(
                dataTitle[index],
                dataRelease[index],
                dataDescription[index],
                dataScore[index],
                dataCaster[index],
                dataDirector[index],
                dataPhoto.getResourceId(index, -1)
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.title)
        dataRelease = resources.getStringArray(R.array.release)
        dataDescription = resources.getStringArray(R.array.description)
        dataScore = resources.getStringArray(R.array.score)
        dataCaster = resources.getStringArray(R.array.caster)
        dataDirector = resources.getStringArray(R.array.director)
        dataPhoto = resources.obtainTypedArray(R.array.photo)
    }
}
