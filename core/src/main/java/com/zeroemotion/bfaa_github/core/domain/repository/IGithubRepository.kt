package com.zeroemotion.bfaa_github.core.domain.repository

import com.zeroemotion.bfaa_github.core.domain.model.User
import io.reactivex.Observable
import io.reactivex.Single

interface IGithubRepository {
    fun getSearchUser(q: String): Observable<List<User>>
    fun getDetail(user: String): Observable<User>
    fun getFollowers(user: String): Observable<List<User>>
    fun getFollowing(user: String): Observable<List<User>>
}