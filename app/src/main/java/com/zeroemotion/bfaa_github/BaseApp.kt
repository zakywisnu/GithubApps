package com.zeroemotion.bfaa_github

import android.app.Application
import com.zeroemotion.bfaa_github.core.di.networkModule
import com.zeroemotion.bfaa_github.core.di.repositoryModule
import com.zeroemotion.bfaa_github.core.di.usecaseModule
import com.zeroemotion.bfaa_github.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@BaseApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    usecaseModule
                )
            )
        }
    }
}