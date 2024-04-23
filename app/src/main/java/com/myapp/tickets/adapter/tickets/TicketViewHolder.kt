package com.myapp.tickets.adapter.tickets

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.myapp.tickets.databinding.TicketsItemCardBinding
import com.myapp.tickets.dto.Ticket
import com.myapp.tickets.utils.AndroidUtils


class TicketViewHolder(
    private val binding: TicketsItemCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ticket: Ticket) {
        val flightDuration = String.format(
            "%.1f",
            AndroidUtils.calculateHoursDifference(
                ticket.departure?.date.toString(),
                ticket.arrival?.date.toString()
            )
        )
        binding.apply {
            if (ticket.badge?.isNotBlank() == true) {
                badge.visibility = View.VISIBLE
                badge.text = ticket.badge.toString()
            }
            price.text = "${ticket.price?.value} ₽"
            departureAirport.text = ticket.departure?.airport.toString()
            arrivalAirport.text = ticket.arrival?.airport.toString()
            departureTime.text = AndroidUtils.formatTime(ticket.departure?.date.toString())
            arrivalTime.text = AndroidUtils.formatTime(ticket.arrival?.date.toString())
            if (ticket.has_transfer == false) {
                duration.text = "$flightDuration ч в пути/Без пересадок"
            } else {
                duration.text = "$flightDuration ч в пути"
            }
        }
    }
}
