package br.com.challengegithubapi.di

import br.com.challengegithubapi.api.HomeService
import br.com.challengegithubapi.api.PrService
import br.com.challengegithubapi.repository.AppRepository
import br.com.challengegithubapi.ui.HomeViewModel
import br.com.challengegithubapi.ui.pr.PullRequestViewModel
import br.com.challengegithubapi.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single { provideRetrofit(Constants.BASE_URL) }
    single<HomeService> { createService(get()) }
    single<PrService> { createService(get()) }
    single { AppRepository(get(), get()) }
}

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

val prModule = module {
    viewModel { PullRequestViewModel(get()) }
}