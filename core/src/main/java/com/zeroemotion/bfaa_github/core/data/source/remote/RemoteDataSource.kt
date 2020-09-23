package com.zeroemotion.bfaa_github.core.data.source.remote

import com.zeroemotion.bfaa_github.core.data.source.remote.network.GithubService
import com.zeroemotion.bfaa_github.core.data.source.remote.response.ListResponse
import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.utils.GithubConstant.TOKEN
import io.reactivex.Observable

class RemoteDataSource(private val githubService: GithubService) {
    fun getSearchUser(q: String): Observable<ListResponse<UserResponse>> {
        return githubService.getSearchUser(q, TOKEN)
    }
    fun getDetail(user:String): Observable<UserResponse>{
        return githubService.getDetail(user, TOKEN)
    }
    fun getFollowers(user: String): Observable<List<UserResponse>>{
        return githubService.getFollowers(user, TOKEN)
    }
    fun getFollowing(user: String): Observable<List<UserResponse>>{
        return githubService.getFollowing(user, TOKEN)
    }
}