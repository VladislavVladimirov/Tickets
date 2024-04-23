package com.myapp.tickets.adapter.offer

import androidx.recyclerview.widget.RecyclerView
import com.myapp.tickets.R
import com.myapp.tickets.databinding.OffersItemCardBinding
import com.myapp.tickets.dto.Offer


class OfferViewHolder (
    private val binding: OffersItemCardBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(offer: Offer) {
        binding.apply {
            name.text = offer.title
            city.text = offer.town
            price.text = buildString {
        append("от ")
        append(offer.price?.value.toString())
        append(" ₽")
    }
            when (offer.id) {
                1 -> {image.setImageResource(R.drawable.offer_1_image)}
                2 -> {image.setImageResource(R.drawable.offer_2_image)}
                3 -> {image.setImageResource(R.drawable.offer_3_image)}
            }
        }
    }
}
