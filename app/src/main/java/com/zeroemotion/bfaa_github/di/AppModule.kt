package com.zeroemotion.bfaa_github.di

import com.zeroemotion.bfaa_github.detail.DetailViewModel
import com.zeroemotion.bfaa_github.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}