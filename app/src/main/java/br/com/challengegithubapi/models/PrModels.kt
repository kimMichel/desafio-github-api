package br.com.challengegithubapi.models

data class PullRequestItem(
    val title: String,
    val user: User,
    val body: String
)

data class User(
    val login: String,
    val avatar_utl: String
)