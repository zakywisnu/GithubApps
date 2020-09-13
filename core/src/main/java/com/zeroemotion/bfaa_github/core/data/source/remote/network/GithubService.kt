package com.zeroemotion.bfaa_github.core.data.source.remote.network

import com.zeroemotion.bfaa_github.core.data.source.remote.response.ListResponse
import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GithubService {

    @GET("search/users?")
    fun getSearchUser(
        @Query("q") q: String,
        @Header("Authorization") token: String
    ): Single<ListResponse<UserResponse>>

}