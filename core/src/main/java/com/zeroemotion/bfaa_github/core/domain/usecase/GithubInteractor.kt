package com.zeroemotion.bfaa_github.core.domain.usecase

import com.zeroemotion.bfaa_github.core.data.GithubRepository
import com.zeroemotion.bfaa_github.core.domain.model.User
import io.reactivex.Single

class GithubInteractor (private val githubRepository: GithubRepository): GithubUseCase{
    override fun getSearchUser(q: String): Single<List<User>> {
        return githubRepository.getSearchUser(q)
    }

}