package com.zeroemotion.bfaa_github.core.utils

import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.domain.model.User

object DataMapper {
    fun mapUserResponseToDomain(input: List<UserResponse>): List<User>{
        val userList = ArrayList<User>()
        input.map {
            val user = User(
                id = it.id,
                login = it.login,
                avatarUrl = it.avatarUrl,
                followersUrl = it.followersUrl,
                followingUrl = it.followingUrl,
                reposUrl = it.reposUrl
            )
            userList.add(user)
        }
        return userList
    }
}