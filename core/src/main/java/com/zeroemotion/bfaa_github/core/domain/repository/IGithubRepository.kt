package com.zeroemotion.bfaa_github.core.domain.repository

import com.zeroemotion.bfaa_github.core.domain.model.User
import io.reactivex.Single

interface IGithubRepository {
    fun getSearchUser(q: String): Single<List<User>>
}