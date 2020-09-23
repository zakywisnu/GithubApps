package com.zeroemotion.bfaa_github.core.data

import android.util.Log
import com.zeroemotion.bfaa_github.core.data.source.remote.RemoteDataSource
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.repository.IGithubRepository
import com.zeroemotion.bfaa_github.core.utils.DataMapper
import io.reactivex.Observable
import io.reactivex.Single

class GithubRepository (private val remoteDataSource: RemoteDataSource): IGithubRepository{

    override fun getSearchUser(q: String): Observable<List<User>> {

        return remoteDataSource.getSearchUser(q).map {
            DataMapper.mapUserListResponseToDomain(it.items)
        }
    }

    override fun getDetail(user: String): Observable<User> {
        return remoteDataSource.getDetail(user).map {
            DataMapper.mapUserResponseToDomain(it)
        }
    }

    override fun getFollowers(user: String): Observable<List<User>> {
        return remoteDataSource.getFollowers(user).map {
            DataMapper.mapUserListResponseToDomain(it)
        }
    }

    override fun getFollowing(user: String): Observable<List<User>> {
        return remoteDataSource.getFollowing(user).map {
            DataMapper.mapUserListResponseToDomain(it)
        }
    }

}