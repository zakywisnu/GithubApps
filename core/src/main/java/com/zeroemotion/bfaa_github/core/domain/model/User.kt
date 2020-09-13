package com.zeroemotion.bfaa_github.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val reposUrl: String,
): Parcelable