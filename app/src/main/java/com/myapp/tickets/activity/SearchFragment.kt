package com.myapp.tickets.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.myapp.tickets.R
import com.myapp.tickets.activity.TicketsFragment.Companion.firstRow
import com.myapp.tickets.activity.TicketsFragment.Companion.secondRow
import com.myapp.tickets.databinding.SearchFragmentBinding
import com.myapp.tickets.dto.TicketOffer
import com.myapp.tickets.utils.AndroidUtils
import com.myapp.tickets.utils.StringArg
import com.myapp.tickets.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.Locale

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchFragment : Fragment() {
    companion object {
        var Bundle.departureCity: String? by StringArg
        var Bundle.arrivalCity: String? by StringArg
    }


    private lateinit var binding: SearchFragmentBinding
    private val viewModel: ViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        var first: TicketOffer
        var second: TicketOffer
        var third: TicketOffer
        val currentDateShort =
            SimpleDateFormat("dd MMM EEE ", Locale.getDefault()).format(System.currentTimeMillis())
                .toString()
        val currentDateLong =
            SimpleDateFormat("dd MMMM", Locale.getDefault()).format(System.currentTimeMillis())
                .toString()
        val departure = requireNotNull(requireArguments().departureCity)
        val arrival = requireNotNull(requireArguments().arrivalCity)
        binding = SearchFragmentBinding.inflate(layoutInflater)
        viewModel.data.observe(viewLifecycleOwner) { state ->
            binding.apply {
                if (state.ticketsOffers.isNotEmpty()) {
                    first = state.ticketsOffers[0]
                    second = state.ticketsOffers[1]
                    third = state.ticketsOffers[2]
                    firstCompanyName.text = first.title
                    firstCompanyPrice.text = "${first.price?.value} ₽"
                    firstCompanyHours.text = first.time_range.joinToString("  ")
                    secondCompanyName.text = second.title
                    secondCompanyPrice.text = "${second.price?.value} ₽"
                    secondCompanyHours.text = second.time_range.joinToString("  ")
                    thirdCompanyName.text = third.title
                    thirdCompanyPrice.text = "${third.price?.value} ₽"
                    thirdCompanyHours.text = third.time_range.joinToString("  ")
                }

                back.setOnClickListener { findNavController().navigateUp() }
                clearIcon.setOnClickListener { to.setText("") }
                switchIcon.setOnClickListener {
                    val before = from.text.toString()
                    from.setText(to.text.toString())
                    to.setText(before)
                }
                from.setText(departure)
                to.setText(arrival)

                chip1.setOnClickListener {
                    context?.let { AndroidUtils.showDatePicker(chip1, it) }
                }
                chip2.text = currentDateShort
                chip2.setOnClickListener {
                    context?.let { AndroidUtils.showDatePicker(chip2, it) }
                }
                showTicketsButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_searchFragment_to_ticketsFragment,
                        Bundle().apply {
                            firstRow = "${from.text}-${to.text}"
                            secondRow = "$currentDateLong, 1 пассажир"
                        })
                }
            }
        }

        return binding.root
    }
}