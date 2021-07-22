package com.crypto.mainmenu.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer as LifecycleObserver
import androidx.lifecycle.LiveData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    fun <T : Any, L : LiveData<T>> Fragment.observe(
        liveData: L,
        body: (T?) -> Unit
    ) {
        liveData.observe(viewLifecycleOwner, LifecycleObserver(body))
    }

    inline fun <T : Any, L : LiveData<T>> Fragment.observeNonNull(
        liveData: L,
        crossinline body: (T) -> Unit
    ) {
        liveData.observe(viewLifecycleOwner,  { it?.let(body) })
    }

}