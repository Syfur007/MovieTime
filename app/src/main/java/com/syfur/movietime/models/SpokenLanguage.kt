package com.syfur.movietime.models

import android.os.Parcel
import android.os.Parcelable

data class SpokenLanguage(
    val english_name: String?,
    val iso_639_1: String?,
    val name: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(english_name)
        parcel.writeString(iso_639_1)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpokenLanguage> {
        override fun createFromParcel(parcel: Parcel): SpokenLanguage {
            return SpokenLanguage(parcel)
        }

        override fun newArray(size: Int): Array<SpokenLanguage?> {
            return arrayOfNulls(size)
        }
    }
}