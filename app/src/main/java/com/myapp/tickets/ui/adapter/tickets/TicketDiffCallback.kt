package com.myapp.tickets.ui.adapter.tickets

import androidx.recyclerview.widget.DiffUtil
import com.myapp.tickets.domain.dto.Ticket

class TicketDiffCallback: DiffUtil.ItemCallback<Ticket>(){
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }
}