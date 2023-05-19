package br.com.challengegithubapi

import android.app.Application
import br.com.challengegithubapi.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinModules()
    }

    private fun startKoinModules() {
        val appModules = listOf(homeModule)
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}