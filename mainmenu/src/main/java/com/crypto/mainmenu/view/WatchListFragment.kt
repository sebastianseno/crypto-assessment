package com.crypto.mainmenu.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.crypto.mainmenu.base.BaseFragment
import com.crypto.mainmenu.common.UiState
import com.crypto.mainmenu.databinding.FragmentWatchListBinding

class WatchListFragment : BaseFragment() {

    private val viewModel: WatchListViewModel by viewModels()

    private var _binding: FragmentWatchListBinding? = null

    private val binding get() = _binding!!

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

        viewModel.refreshTotalTopTier(50,"USD")
        binding.recycler.adapter = adapter
        observe(viewModel.cryptoData) {
            adapter.items = it ?: emptyList()
        }
        observeNonNull(viewModel.state, ::handleState)

    }

    private fun handleState(uiState: UiState?) {
        when (uiState) {
            UiState.Success -> {
                Log.d("senoo", "Sukses")

            }
            UiState.Loading -> {
                Log.d("senoo", "Loading")

            }
            is UiState.Error -> {
                Log.d("senoo", uiState.message)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}