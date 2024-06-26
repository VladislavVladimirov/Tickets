package com.myapp.tickets.domain.dto


data class TicketOffer(
    val id: Int? = null,
    val price: Price? = null,
    val time_range: List<String> = emptyList(),
    val title: String? = null
)
