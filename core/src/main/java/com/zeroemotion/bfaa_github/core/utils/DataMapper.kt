package com.zeroemotion.bfaa_github.core.utils

import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.domain.model.User

object DataMapper {
    fun mapUserListResponseToDomain(input: List<UserResponse>): List<User>{
        val userList = ArrayList<User>()
        input.map {
            val user = User(
                userId = it.userId,
                login = it.login,
                avatarUrl = it.avatarUrl,
                followers = it.followers,
                following = it.following,
                publicRepos = it.publicRepos
            )
            userList.add(user)
        }
        return userList
    }

    fun mapUserResponseToDomain(input: UserResponse) = User(
        userId = input.userId,
        login = input.login,
        avatarUrl = input.avatarUrl,
        followers = input.followers,
        following = input.following,
        publicRepos = input.publicRepos
    )
}