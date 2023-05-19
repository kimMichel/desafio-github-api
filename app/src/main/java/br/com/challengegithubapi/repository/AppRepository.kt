package br.com.challengegithubapi.repository

import android.util.Log
import br.com.challengegithubapi.api.HomeService
import br.com.challengegithubapi.models.HomeItem

class AppRepository(private val apiService: HomeService) {
    val repositories: MutableList<HomeItem> = mutableListOf()

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
}