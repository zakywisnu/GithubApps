package com.zeroemotion.bfaa_github.core.domain.usecase

import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.repository.IGithubRepository
import io.reactivex.Single

class GithubInteractor (private val githubRepository: IGithubRepository): GithubUseCase{
    override fun getSearchUser(q: String): Single<List<User>> {
        return githubRepository.getSearchUser(q)
    }

    override fun getDetail(user: String): Single<User> {
        return githubRepository.getDetail(user)
    }

    override fun getFollowers(user: String): Single<List<User>> {
        return githubRepository.getFollowers(user)
    }

    override fun getFollowing(user: String): Single<List<User>> {
        return githubRepository.getFollowing(user)
    }

}