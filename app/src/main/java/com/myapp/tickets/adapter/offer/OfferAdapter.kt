package com.myapp.tickets.adapter.offer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.myapp.tickets.databinding.OffersItemCardBinding
import com.myapp.tickets.dto.Offer


class OfferAdapter(): ListAdapter<Offer, OfferViewHolder>(OfferDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = OffersItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder((binding))

    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = getItem(position)
        holder.bind(offer)
    }
}