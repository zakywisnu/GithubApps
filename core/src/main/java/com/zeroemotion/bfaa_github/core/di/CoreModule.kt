package com.zeroemotion.bfaa_github.core.di

import com.zeroemotion.bfaa_github.core.data.GithubRepository
import com.zeroemotion.bfaa_github.core.data.source.remote.RemoteDataSource
import com.zeroemotion.bfaa_github.core.data.source.remote.network.GithubService
import com.zeroemotion.bfaa_github.core.domain.repository.IGithubRepository
import com.zeroemotion.bfaa_github.core.domain.usecase.GithubInteractor
import com.zeroemotion.bfaa_github.core.domain.usecase.GithubUseCase
import com.zeroemotion.bfaa_github.core.utils.GithubConstant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()

        retrofit.create(GithubService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IGithubRepository> { GithubRepository(get()) }
}

val usecaseModule = module {
    factory<GithubUseCase> { GithubInteractor(get()) }
}