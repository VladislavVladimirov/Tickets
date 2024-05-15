package com.myapp.tickets.domain.model

import com.myapp.tickets.domain.dto.Offer
import com.myapp.tickets.domain.dto.Ticket
import com.myapp.tickets.domain.dto.TicketOffer

data class Model(
    val offers: List<Offer> = emptyList(),
    val tickets: List<Ticket> = emptyList(),
    val ticketsOffers: List<TicketOffer> = emptyList(),
    val loading: Boolean = false,
    val error: Boolean = false,
)