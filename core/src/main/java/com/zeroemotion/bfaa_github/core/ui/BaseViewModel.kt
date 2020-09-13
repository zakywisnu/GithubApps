package com.zeroemotion.bfaa_github.core.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(){
    val disposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}