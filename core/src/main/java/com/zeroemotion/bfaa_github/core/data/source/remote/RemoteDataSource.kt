package com.zeroemotion.bfaa_github.core.data.source.remote

import android.util.Log
import com.zeroemotion.bfaa_github.core.data.source.remote.network.GithubService
import com.zeroemotion.bfaa_github.core.data.source.remote.response.ListResponse
import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.utils.GithubConstant.TOKEN
import io.reactivex.Single

class RemoteDataSource(private val githubService: GithubService) {
    fun getSearchUser(q: String): Single<ListResponse<UserResponse>> {
        return githubService.getSearchUser(q, TOKEN)
    }
    fun getDetail(user:String): Single<UserResponse>{
        return githubService.getDetail(user, TOKEN)
    }
    fun getFollowers(user: String): Single<List<UserResponse>>{
        return githubService.getFollowers(user, TOKEN)
    }
    fun getFollowing(user: String): Single<List<UserResponse>>{
        return githubService.getFollowing(user, TOKEN)
    }
}