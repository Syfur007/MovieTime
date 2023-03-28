package com.syfur.movietime.models

import android.os.Parcel
import android.os.Parcelable

data class MovieModel(
    val adult: Boolean?,
    val backdrop_path: String?,
    val budget: Int?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val production_companies: List<ProductionCompany>?,
    val production_countries: List<ProductionCountry>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readInt(),
        parcel.createTypedArrayList(Genre),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.createTypedArrayList(ProductionCompany),
        parcel.createTypedArrayList(ProductionCountry),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.createTypedArrayList(SpokenLanguage),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (adult == true) 1 else 0)
        parcel.writeString(backdrop_path)
        parcel.writeInt(budget ?: 0)
        parcel.writeTypedList(genres)
        parcel.writeString(homepage)
        parcel.writeInt(id ?: 0)
        parcel.writeString(imdb_id)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeDouble(popularity ?: 0.0)
        parcel.writeString(poster_path)
        parcel.writeTypedList(production_companies)
        parcel.writeTypedList(production_countries)
        parcel.writeString(release_date)
        parcel.writeInt(revenue ?: 0)
        parcel.writeInt(runtime ?: 0)
        parcel.writeTypedList(spoken_languages)
        parcel.writeString(status)
        parcel.writeString(tagline)
        parcel.writeString(title)
        parcel.writeByte(if (video == true) 1 else 0)
        parcel.writeDouble(vote_average ?: 0.0)
        parcel.writeInt(vote_count ?: 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}
