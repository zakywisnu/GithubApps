package com.zeroemotion.bfaa_github.core.domain.usecase

import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.repository.IGithubRepository
import io.reactivex.Single

class GithubInteractor (private val githubRepository: IGithubRepository): GithubUseCase{
    override fun getSearchUser(q: String): Single<List<User>> {
        return githubRepository.getSearchUser(q)
    }

}