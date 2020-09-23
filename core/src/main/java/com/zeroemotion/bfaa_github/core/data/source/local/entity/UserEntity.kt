package com.zeroemotion.bfaa_github.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userentity")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var userId: Int,
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "avatar_url")
    var avatarUrl: String,
    @ColumnInfo(name = "followers")
    var followers: Int,
    @ColumnInfo(name = "following")
    var following: Int,
    @ColumnInfo(name = "public_repos")
    var publicRepos: Int
)