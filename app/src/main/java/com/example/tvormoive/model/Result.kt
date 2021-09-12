package com.example.tvormoive.model

import android.os.Parcelable
import com.example.tvormoive.utils.Image_Path
import com.example.tvormoive.utils.ShowType
import com.example.tvormoive.utils.UNKNOWN
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.text.DecimalFormat

@Parcelize
data class Result(
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("overview") val overview: String?,
    @SerializedName("release_date") val release_date: String?,
    @SerializedName("first_air_date") val first_air_date: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("vote_count") val vote_count: Int?,
    @SerializedName("vote_average") val vote_average: Double?
) : Parcelable {
    val showPoster get() = Image_Path + poster_path
    val showBackPoster get() = Image_Path + backdrop_path
    val voteAverageWithOneDecimalPlace
        get() = if (vote_average == null) 0.0 else DecimalFormat("#.#").format(
            vote_average
        ).toDouble()
    val fullReleaseDate get() = release_date ?: first_air_date ?: UNKNOWN
    val showTitle get() = title ?: name ?: UNKNOWN
    val descriptionOrEmpty get() = if (overview != null && overview.isEmpty()) "No Overview" else overview
    val showType get() = if (title == null) ShowType.TV else ShowType.MOVIE
    val voteCount get() = vote_count ?: 0.0
    fun getTheYearOfReleaseDateYear() =
        if (release_date != null && release_date.length > 4) release_date.slice(0..3)
        else if (first_air_date != null && first_air_date.length > 4) first_air_date.slice(0..3)
        else UNKNOWN
}