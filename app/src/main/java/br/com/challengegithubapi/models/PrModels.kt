package br.com.challengegithubapi.models


data class PRResponse(
    val requests: List<PullRequestItem>
)

data class PullRequestItem(
    val title: String,
    val user: User,
    val body: String
)

data class User(
    val login: String,
    val avatar_url: String
)