package com.myapp.tickets.domain.dto.response

import com.myapp.tickets.domain.dto.TicketOffer

data class TicketOffersResponse(
    val tickets_offers: List<TicketOffer>
)
