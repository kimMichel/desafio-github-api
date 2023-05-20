package br.com.challengegithubapi.repository

import android.util.Log
import br.com.challengegithubapi.api.HomeService
import br.com.challengegithubapi.api.PrService
import br.com.challengegithubapi.models.HomeItem
import br.com.challengegithubapi.models.PullRequestItem

class AppRepository(
    private val apiService: HomeService,
    private val prApiService: PrService
    ) {
    val repositories: MutableList<HomeItem> = mutableListOf()
    val requests: MutableList<PullRequestItem> = mutableListOf()

    suspend fun fetchData() {
        try {
            val response = apiService.getRepositories()
            if (response.isSuccessful) {
                repositories.addAll(response.body()?.items ?: listOf())
            } else {
                Log.e("Fetch Data", "Failed to fetch data: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("Fetch Data", "Failed to fetch data: ${e.cause}")
        }
    }

    suspend fun fetchPrData(user: String, repository: String) {
        try {
            val response = prApiService.getPullRequests(user, repository)
            if (response.isSuccessful) {
                requests.addAll(response.body()?.requests ?: listOf())
            } else {
                Log.e("Fetch Data", "Failed to fetch data: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("Fetch Data", "Failed to fetch data: ${e.cause}")
        }
    }
}