package br.com.challengegithubapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.challengegithubapi.databinding.HomeItemBinding
import br.com.challengegithubapi.models.HomeItem
import com.squareup.picasso.Picasso

class HomeAdapter(
    private val repositories: MutableList<HomeItem>,
    var listener: OnHomeClickListener
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    interface OnHomeClickListener {
        fun onHomeClick(user: String, repo: String)
    }

    inner class HomeViewHolder(
        private val binding: HomeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onHomeClick(repositories[position].owner.login, repositories[position].name)
            }
        }
        fun bind(repository: HomeItem) = with(binding) {
            userName.text = repository.owner.login
            repoName.text = repository.name
            repoDescription.text = repository.description
            repoForkCounter.text = repository.forks_count.toString()
            repoStarCounter.text = repository.stargazers_count.toString()
            Picasso.get().load(repository.owner.avatar_url).into(profileImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.bind(repositories[position])
    }

    override fun getItemCount(): Int = repositories.size
}