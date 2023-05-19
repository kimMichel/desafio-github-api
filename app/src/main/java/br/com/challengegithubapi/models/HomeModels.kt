package br.com.challengegithubapi.models

data class HomeItems(
    val items: List<HomeItem>
)

data class HomeItem(
    val name: String, // repository name
    val owner: RepositoryOwner,
    val description: String,
    val stargazers_count: Int, // repository stars
    val forks_count: Int // repository forks count
)

data class RepositoryOwner(
    val login: String,
    val avatar_url: String
)