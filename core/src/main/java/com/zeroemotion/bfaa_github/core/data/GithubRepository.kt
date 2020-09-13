package com.zeroemotion.bfaa_github.core.data

import com.zeroemotion.bfaa_github.core.data.source.remote.RemoteDataSource
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.repository.IGithubRepository
import com.zeroemotion.bfaa_github.core.utils.DataMapper
import io.reactivex.Single

class GithubRepository (private val remoteDataSource: RemoteDataSource): IGithubRepository{
    override fun getSearchUser(q: String): Single<List<User>> {
        return remoteDataSource.getSearchUser(q).map {
            DataMapper.mapUserResponseToDomain(it.items)
        }
    }

}