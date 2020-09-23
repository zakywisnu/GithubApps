package com.zeroemotion.bfaa_github.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.usecase.GithubUseCase
import com.zeroemotion.bfaa_github.core.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailViewModel (private val githubUseCase: GithubUseCase): BaseViewModel(){

    val dataUser = MutableLiveData<List<User>>()
    val dataDetail = MutableLiveData<User>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun getDetail(user: String){
        loading.value = true
        disposable.add(
            githubUseCase.getDetail(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loading.value = false
                    dataDetail.value = it
                },{
                    error.value = true
                    loading.value = false
                })
        )
    }

    fun getFollowers(user: String){
        loading.value = true
        disposable.add(
            githubUseCase.getFollowers(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.i("listuser", it.toString())
                    loading.value = false
                    dataUser.value = it
                },{
                    error.value = true
                    loading.value = false
                })
        )
    }

    fun getFollowing(user: String){
        loading.value = true
        disposable.add(
            githubUseCase.getFollowing(user)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    dataUser.value = it
                    loading.value = false
                },{
                    error.value = true
                    loading.value = false
                })
        )
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}