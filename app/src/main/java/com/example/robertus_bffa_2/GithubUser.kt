package com.example.robertus_bffa_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val id: Int,
    val login: String,
    val avatar_url: String,
    val name: String?,
    val location: String?,
    val type: String?,
    val public_repos: Int,
    val followers: Int,
    val following: Int
) : Parcelable
