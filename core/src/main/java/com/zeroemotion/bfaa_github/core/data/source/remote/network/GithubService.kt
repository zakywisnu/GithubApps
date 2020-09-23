package com.zeroemotion.bfaa_github.core.data.source.remote.network

import com.zeroemotion.bfaa_github.core.data.source.remote.response.ListResponse
import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.domain.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users?")
    fun getSearchUser(
        @Query("q") q: String,
        @Header("Authorization") token: String
    ): Observable<ListResponse<UserResponse>>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Observable<List<UserResponse>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Observable<List<UserResponse>>

    @GET("users/{username}")
    fun getDetail(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Observable<UserResponse>

}