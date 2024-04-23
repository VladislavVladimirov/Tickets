package com.myapp.tickets.dto.response

import com.myapp.tickets.dto.Ticket

data class TicketsResponse(
    val tickets: List<Ticket>
)
