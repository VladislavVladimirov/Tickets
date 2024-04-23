package com.myapp.tickets.adapter.tickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.myapp.tickets.databinding.TicketsItemCardBinding
import com.myapp.tickets.dto.Ticket


class TicketAdapter(): ListAdapter<Ticket, TicketViewHolder>(TicketDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = TicketsItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder((binding))

    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = getItem(position)
        holder.bind(ticket)
    }
}