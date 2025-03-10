package com.example.submissionandroidexpert.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroidexpert.R
import com.example.submissionandroidexpert.core.data.Resource
import com.example.submissionandroidexpert.core.ui.TeamAdapter
import com.example.submissionandroidexpert.databinding.FragmentHomeBinding
import com.example.submissionandroidexpert.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val searchViewModel: SearchViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


            homeViewModel.team.observe(viewLifecycleOwner) { team ->
                if (team != null) {
                    when (team) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            teamAdapter.submitList(team.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                team.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }

            binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        searchViewModel.searchTeam(it).observe(viewLifecycleOwner) { searchResults ->
                            teamAdapter.submitList(searchResults)
                            binding.viewEmptySearch.root.visibility =
                                if (searchResults.isNotEmpty()) View.GONE else View.VISIBLE
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        searchViewModel.searchTeam(it).observe(viewLifecycleOwner) { searchResults ->
                            teamAdapter.submitList(searchResults)
                            binding.viewEmptySearch.root.visibility =
                                if (searchResults.isNotEmpty()) View.GONE else View.VISIBLE
                        }
                    }
                    return true
                }
            })
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}