package com.myapp.tickets.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.myapp.tickets.ui.adapter.tickets.TicketAdapter
import com.myapp.tickets.databinding.TicketsFragmentBinding
import com.myapp.tickets.utils.StringArg
import com.myapp.tickets.ui.viewmodel.TicketsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class TicketsFragment : Fragment() {
    companion object {
        var Bundle.firstRow: String? by StringArg
        var Bundle.secondRow: String? by StringArg
    }
    private lateinit var binding: TicketsFragmentBinding
    private val viewModel: TicketsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val first = requireNotNull(requireArguments().firstRow)
        val second = requireNotNull(requireArguments().secondRow)
        val adapter = TicketAdapter()
        binding = TicketsFragmentBinding.inflate(layoutInflater)
        viewModel.data.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.tickets)
            binding.apply {
                list.adapter = adapter
                back.setOnClickListener { findNavController().navigateUp() }
                route.text = first
                info.text = second
            }
        }
        return binding.root
    }
}