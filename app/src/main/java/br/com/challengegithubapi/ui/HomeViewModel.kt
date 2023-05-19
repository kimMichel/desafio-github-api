package br.com.challengegithubapi.ui

import androidx.lifecycle.ViewModel
import br.com.challengegithubapi.models.HomeItem
import br.com.challengegithubapi.models.RepositoryOwner

class HomeViewModel: ViewModel() {
    val repositories: MutableList<HomeItem> = mutableListOf(
        HomeItem(
            name = "LeetCodeAnimation",
            owner = RepositoryOwner(
                login = "MisterBooo",
                "https://avatars.githubusercontent.com/u/15308811?v=4",
            ),
            description = "Demonstrate all the questions on LeetCode in the form of animation.（用动画的形式呈现解LeetCode题目的思路）",
            stargazers_count = 73127,
            forks_count = 13918
        ),
        HomeItem(
            name = "LeetCodeAnimation",
            owner = RepositoryOwner(
                login = "MisterBooo",
                "https://avatars.githubusercontent.com/u/64886238?v=4",
            ),
            description = "Demonstrate all the questions on LeetCode in the form of animation.（用动画的形式呈现解LeetCode题目的思路）",
            stargazers_count = 73127,
            forks_count = 13918
        ),
        HomeItem(
            name = "LeetCodeAnimation",
            owner = RepositoryOwner(
                login = "MisterBooo",
                "https://avatars.githubusercontent.com/u/15308811?v=4",
            ),
            description = "Demonstrate all the questions on LeetCode in the form of animation.（用动画的形式呈现解LeetCode题目的思路）",
            stargazers_count = 73127,
            forks_count = 13918
        ),HomeItem(
            name = "LeetCodeAnimation",
            owner = RepositoryOwner(
                login = "MisterBooo",
                "https://avatars.githubusercontent.com/u/15308811?v=4",
            ),
            description = "Demonstrate all the questions on LeetCode in the form of animation.（用动画的形式呈现解LeetCode题目的思路）",
            stargazers_count = 73127,
            forks_count = 13918
        ),

    )
}