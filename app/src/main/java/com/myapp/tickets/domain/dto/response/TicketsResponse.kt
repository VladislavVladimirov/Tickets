package com.myapp.tickets.domain.dto.response

import com.myapp.tickets.domain.dto.Ticket

data class TicketsResponse(
    val tickets: List<Ticket>
)
