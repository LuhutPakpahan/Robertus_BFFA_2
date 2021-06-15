package com.example.robertus_bffa_2

import android.os.Parcelable
import com.example.robertus_bffa_2.GithubUser
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRespond(
    val total_count : String,
    val incomplete_results: Boolean? = null,
    val items : List<GithubUser>
): Parcelable