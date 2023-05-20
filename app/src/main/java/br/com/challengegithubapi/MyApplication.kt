package br.com.challengegithubapi

import android.app.Application
import br.com.challengegithubapi.di.homeModule
import br.com.challengegithubapi.di.mainModule
import br.com.challengegithubapi.di.prModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoinModules()
    }

    private fun startKoinModules() {
        val appModules = listOf(mainModule, homeModule, prModule)
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}