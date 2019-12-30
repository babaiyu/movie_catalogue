package com.example.moviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var title: String,
    var release: String,
    var description: String,
    var score: String,
    var caster: String,
    var director: String,
    var photo: Int
) : Parcelable