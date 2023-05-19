package br.com.challengegithubapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.challengegithubapi.models.HomeItem
import br.com.challengegithubapi.repository.AppRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: AppRepository): ViewModel() {
    val repositories: MutableList<HomeItem> = repository.repositories
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun getRepositories() = viewModelScope.launch {
        isLoading.value = true
        repository.fetchData()
    }.invokeOnCompletion { isLoading.value = false }
}