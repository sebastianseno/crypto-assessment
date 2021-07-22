package com.crypto.mainmenu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crypto.mainmenu.base.BaseFragment
import com.crypto.mainmenu.common.UiState
import com.crypto.mainmenu.databinding.FragmentWatchListBinding
import com.crypto.mainmenu.network.entity.Data

class WatchListFragment : BaseFragment() {

    private val viewModel: WatchListViewModel by viewModels()

    private var _binding: FragmentWatchListBinding? = null

    private val binding get() = _binding!!

    private var loading = true

    private var arrayData : MutableList<Data> = mutableListOf()

    var page = 1

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        WatchListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefresh.setOnRefreshListener {
            page = 1
            arrayData.clear()
            viewModel.refreshTotalTopTier(true, 1, 10, "USD")
        }
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            page += 1
                            viewModel.refreshTotalTopTier(true, page, 10, "USD")
                        }
                    }
                }
            }
        }
        viewModel.refreshTotalTopTier(false, 1, 10, "USD")
        binding.recycler.adapter = adapter
        binding.recycler.addOnScrollListener(scrollListener)

        observe(viewModel.cryptoData) {
            arrayData.addAll(it!!.toMutableList())
            adapter.items = arrayData
            binding.recycler.isVisible = !it.isNullOrEmpty()
            binding.emptyLayout.container.isVisible = it.isNullOrEmpty()
        }
        observeNonNull(viewModel.state, ::handleState)
    }

    private fun handleState(uiState: UiState?) {
        binding.progressBar.isVisible = uiState == UiState.Loading
        binding.swipeRefresh.isRefreshing = uiState == UiState.Refreshing
        binding.recycler.isVisible = uiState == UiState.Success
        binding.errorLayout.container.isVisible = uiState is UiState.Error
    }

    override fun onDestroyView() {
        super.onDestroyView()
        arrayData.clear()
        _binding = null
    }
}