package com.example.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.*
import com.bumptech.glide.Glide

class MovieAdapter internal constructor(private val context: Context): BaseAdapter() {
    internal var movies = arrayListOf<Movie>()
    override fun getView(index: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }
        val viewMovieHolder = ViewHolder(itemView as View)

        val movie = getItem(index) as Movie
        viewMovieHolder.bind(movie)
        return itemView
    }

    inner class ViewHolder constructor(private val view: View) {
        fun bind(movie: Movie) {
            with(view) {
                txt_title.text = movie.title
                txt_release.text = movie.release
                txt_description.text = movie.description
                Glide.with(img_photo)
                    .load(movie.photo)
                    .into(img_photo)
            }
        }
    }

    override fun getItem(index: Int): Any = movies[index]

    override fun getItemId(index: Int): Long = index.toLong()

    override fun getCount(): Int = movies.size
}