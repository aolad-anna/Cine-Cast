package com.example.kitkat_movie.model

import Era
import Genre
import Languages
import Thumbnails
import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("thumbnails") val thumbnails : Thumbnails,
                 @SerializedName("id") val id : String,
                 @SerializedName("title") val title : String,
                 @SerializedName("duration_sec") val duration_sec : Int,
                 @SerializedName("genre") val genre : Genre,
                 @SerializedName("release_year") val release_year : Int,
                 @SerializedName("era") val era : Era,
                 @SerializedName("singer_count") val singer_count : Int,
                 @SerializedName("key") val key : String,
                 @SerializedName("artist_display_name") val artist_display_name : String,
                 @SerializedName("artists_display_placeholder") val artists_display_placeholder : String,
                 @SerializedName("bpm") val bpm : Int,
                 @SerializedName("parental_advisory") val parental_advisory : String,
                 @SerializedName("lead_gender") val lead_gender : String,
                 @SerializedName("added_date") val added_date : String,
                 @SerializedName("key_scale") val key_scale_scale : String,
                 @SerializedName("key_accidental") val key_accidental_accidental : String,
                 @SerializedName("key_pitch") val key_pitch_pitch : String,
                 @SerializedName("languages") val languages : List<Languages>,
                 @SerializedName("popularity") val popularity : Double,
                 @SerializedName("album_cover_generic") val album_cover_generic : Boolean,
                 @SerializedName("is_blank") val is_blank : Boolean)
