package com.zeroemotion.bfaa_github.core.data.source.remote

import com.zeroemotion.bfaa_github.core.data.source.remote.network.GithubService
import com.zeroemotion.bfaa_github.core.data.source.remote.response.ListResponse
import com.zeroemotion.bfaa_github.core.data.source.remote.response.UserResponse
import com.zeroemotion.bfaa_github.core.utils.GithubConstant.TOKEN
import io.reactivex.Single

class RemoteDataSource(private val githubService: GithubService) {
    fun getSearchUser(q: String): Single<ListResponse<UserResponse>> {
        return githubService.getSearchUser(q, TOKEN)
    }
}