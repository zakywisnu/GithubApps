package com.zeroemotion.bfaa_github.home

import androidx.lifecycle.MutableLiveData
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.domain.usecase.GithubUseCase
import com.zeroemotion.bfaa_github.core.ui.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val githubUseCase: GithubUseCase) : BaseViewModel() {

    val dataUser = MutableLiveData<List<User>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun getUser(query: String) {
        loading.value = true
        disposable.add(
            githubUseCase.getSearchUser(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loading.value = false
                    dataUser.value = it
                }, {
                    loading.value = false
                    error.value = true
                })
        )
    }

}