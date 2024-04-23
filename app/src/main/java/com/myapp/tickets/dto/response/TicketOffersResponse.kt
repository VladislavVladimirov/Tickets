package com.myapp.tickets.dto.response

import com.myapp.tickets.dto.TicketOffer

data class TicketOffersResponse(
    val tickets_offers: List<TicketOffer>
)
