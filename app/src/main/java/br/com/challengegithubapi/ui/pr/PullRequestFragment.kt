package br.com.challengegithubapi.ui.pr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.challengegithubapi.R
import br.com.challengegithubapi.databinding.FragmentPullRequestBinding
import org.koin.android.ext.android.inject

class PullRequestFragment : Fragment() {

    private lateinit var binding: FragmentPullRequestBinding
    private val viewModel: PullRequestViewModel by inject()
    private val args: PullRequestFragmentArgs by navArgs()

    private val adapter: PullRequestAdapter = PullRequestAdapter(viewModel.requests)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPullRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
        setViews()
        setRecycler()
    }

    private fun fetchData() {
        viewModel.getPRs(args.user, args.repo)
    }

    private fun setRecycler() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun setViews() = with(binding) {
        prOpened.text = getString(R.string.pr_opened, viewModel.requests.size)
        viewModel.isLoading.observe(viewLifecycleOwner) {
            recyclerView.isVisible = !it
            prOpened.isVisible = !it
            loading.isVisible = it
        }
    }

}