package br.com.challengegithubapi.ui.pr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.challengegithubapi.models.PullRequestItem
import br.com.challengegithubapi.repository.AppRepository
import kotlinx.coroutines.launch

class PullRequestViewModel(private val repository: AppRepository): ViewModel() {
    val requests: MutableList<PullRequestItem> = repository.requests

    fun getPRs(user: String, repo: String) = viewModelScope.launch {
        repository.fetchPrData(user, repo)
    }
}