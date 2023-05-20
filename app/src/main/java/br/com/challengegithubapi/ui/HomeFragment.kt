package br.com.challengegithubapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.challengegithubapi.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), HomeAdapter.OnHomeClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by inject()

    private lateinit var adapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
        setViews()
        setRecycler()
    }

    private fun setViews() = with(binding) {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            recyclerView.isVisible = !it
            loading.isVisible = it
        }
    }

    private fun setRecycler() = with(binding) {
        adapter = HomeAdapter(viewModel.repositories, this@HomeFragment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun fetchData() {
        if (viewModel.repositories.isEmpty()) {
            viewModel.getRepositories()
        }
    }

    override fun onHomeClick(user: String, repo: String) {
        HomeFragmentDirections.actionHomeFragmentToPullRequestFragment(user, repo).apply {
            findNavController().navigate(this)
        }
    }
}