package com.myapp.tickets.activity

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.myapp.tickets.R
import com.myapp.tickets.activity.SearchFragment.Companion.arrivalCity
import com.myapp.tickets.activity.SearchFragment.Companion.departureCity
import com.myapp.tickets.adapter.offer.OfferAdapter
import com.myapp.tickets.adapter.offer.OfferItemDecoration
import com.myapp.tickets.databinding.MainFragmentBinding
import com.myapp.tickets.databinding.SearchDialogFragmentBinding
import com.myapp.tickets.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adapter = OfferAdapter()
        val spacing = resources.getDimensionPixelSize(R.dimen.common_spacing)

        binding = MainFragmentBinding.inflate(layoutInflater)
        viewModel.data.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.offers)
            binding.apply {
                list.adapter = adapter
                list.addItemDecoration(OfferItemDecoration(spacing))
                from.setText(viewModel.getDraft())
                from.addTextChangedListener {
                    viewModel.saveDraft(
                        it.toString()
                    )
                }
                to.setOnClickListener {
                    val searchDialogFragmentBinding =
                        SearchDialogFragmentBinding.inflate(layoutInflater)
                    val dialog = BottomSheetDialog(requireActivity())
                    dialog.setContentView(searchDialogFragmentBinding.root)
                    val displayMetrics = Resources.getSystem().displayMetrics
                    val screenHeight = displayMetrics.heightPixels
                    val marginTop =
                        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, displayMetrics)
                            .toInt()
                    val dialogHeight = screenHeight - marginTop
                    val bottomSheet =
                        dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
                    val layoutParams = bottomSheet?.layoutParams
                    layoutParams?.height = dialogHeight
                    bottomSheet?.layoutParams = layoutParams
                    val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    dialog.show()
                    searchDialogFragmentBinding.apply {

                        from.setText(binding.from.text.toString())
                        clearIcon.setOnClickListener {
                            to.setText("")
                        }
                        anywhere.setOnClickListener {
                            to.setText(R.string.anywhere)
                            if (from.text.toString().isNotBlank()) {
                                dialog.dismiss()
                                findNavController().navigate(
                                    R.id.action_mainFragment_to_searchFragment,
                                    Bundle().apply {
                                        departureCity = from.text.toString()
                                        arrivalCity = to.text.toString()
                                    })
                            }
                        }
                        complexRoute.setOnClickListener {
                            dialog.dismiss()
                            findNavController().navigate(R.id.action_mainFragment_to_complexRouteFragment)

                        }
                        holidays.setOnClickListener {
                            dialog.dismiss()
                            findNavController().navigate(R.id.action_mainFragment_to_holidaysFragment)

                        }
                        hotTickets.setOnClickListener {
                            dialog.dismiss()
                            findNavController().navigate(R.id.action_mainFragment_to_hotTicketsFragment)

                        }
                        route1.setOnClickListener {

                            to.setText(R.string.istanbul)
                            dialog.dismiss()
                            findNavController().navigate(
                                R.id.action_mainFragment_to_searchFragment,
                                Bundle().apply {
                                    departureCity = from.text.toString()
                                    arrivalCity = to.text.toString()
                                })

                        }
                        route2.setOnClickListener {
                            to.setText(R.string.sochi)
                            dialog.dismiss()
                            findNavController().navigate(
                                R.id.action_mainFragment_to_searchFragment,
                                Bundle().apply {
                                    departureCity = from.text.toString()
                                    arrivalCity = to.text.toString()
                                })

                        }
                        route3.setOnClickListener {
                            to.setText(R.string.phuket)
                            dialog.dismiss()
                            findNavController().navigate(
                                R.id.action_mainFragment_to_searchFragment,
                                Bundle().apply {
                                    departureCity = from.text.toString()
                                    arrivalCity = to.text.toString()
                                })

                        }
                        to.setOnEditorActionListener { _, actionId, _ ->
                            if (actionId == EditorInfo.IME_ACTION_DONE) {
                                dialog.dismiss()
                                findNavController().navigate(
                                    R.id.action_mainFragment_to_searchFragment,
                                    Bundle().apply {
                                        departureCity = from.text.toString()
                                        arrivalCity = to.text.toString()
                                    })

                                true
                            } else false
                        }
                    }
                }
            }

        }
        return binding.root
    }
}
