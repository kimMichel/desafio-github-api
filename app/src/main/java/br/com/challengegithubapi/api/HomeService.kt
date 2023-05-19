package br.com.challengegithubapi.api

import br.com.challengegithubapi.models.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("/search/repositories")
    suspend fun getRepositories(
        @Query("q") query: String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int = 1
    ): Response<RepositoryResponse>

}