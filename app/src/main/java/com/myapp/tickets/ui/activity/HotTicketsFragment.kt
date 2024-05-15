package com.myapp.tickets.ui.activity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.myapp.tickets.databinding.HotTickersFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HotTicketsFragment: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = HotTickersFragmentBinding.inflate(inflater, container, false)

        binding.apply {
            back.setOnClickListener {
                findNavController().navigateUp()
            }

        }
        return binding.root
    }

}