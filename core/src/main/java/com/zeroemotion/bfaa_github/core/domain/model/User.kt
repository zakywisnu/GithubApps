package com.zeroemotion.bfaa_github.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userId: Int,
    val login: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int,
    val publicRepos: Int,
): Parcelable