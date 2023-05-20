package br.com.challengegithubapi.ui.pr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.challengegithubapi.databinding.PrItemBinding
import br.com.challengegithubapi.models.PullRequestItem
import com.squareup.picasso.Picasso

class PullRequestAdapter(
    private val requests: MutableList<PullRequestItem>
    ): RecyclerView.Adapter<PullRequestAdapter.PRViewHolder>() {

    inner class PRViewHolder(private val binding: PrItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(request: PullRequestItem) = with(binding) {
            prTitle.text = request.title
            prDescription.text = request.body
            userName.text = request.user.login
            Picasso.get().load(request.user.avatar_url).into(profileImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestAdapter.PRViewHolder {
        val binding = PrItemBinding.inflate(LayoutInflater.from(parent.context))
        return PRViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        holder.bind(requests[position])
    }

    override fun getItemCount(): Int = requests.size

}