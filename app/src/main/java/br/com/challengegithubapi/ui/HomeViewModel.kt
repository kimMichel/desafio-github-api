package br.com.challengegithubapi.ui

import androidx.lifecycle.ViewModel
import br.com.challengegithubapi.models.HomeItem
import br.com.challengegithubapi.repository.AppRepository

class HomeViewModel(repository: AppRepository): ViewModel() {
    val repositories: MutableList<HomeItem> = repository.repositories
}