package br.com.challengegithubapi.di

import br.com.challengegithubapi.repository.AppRepository
import br.com.challengegithubapi.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single { AppRepository() }
    viewModel { HomeViewModel(get()) }
}