package br.com.challengegithubapi.api

import br.com.challengegithubapi.models.PullRequestItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PrService {

    @GET("/repos/{user}/{repository}/pulls")
    suspend fun getPullRequests(
        @Path("user") user: String,
        @Path("repository") repository: String
    ): Response<List<PullRequestItem>>

}