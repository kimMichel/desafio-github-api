package br.com.challengegithubapi.di

import br.com.challengegithubapi.api.HomeService
import br.com.challengegithubapi.repository.AppRepository
import br.com.challengegithubapi.ui.HomeViewModel
import br.com.challengegithubapi.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single { provideRetrofit(Constants.BASE_URL) }
    single<HomeService> { createService(get()) }
    single { AppRepository(get()) }
    viewModel { HomeViewModel(get()) }
}