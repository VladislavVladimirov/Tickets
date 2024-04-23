package com.myapp.tickets.model

import com.myapp.tickets.dto.Offer
import com.myapp.tickets.dto.Ticket
import com.myapp.tickets.dto.TicketOffer

data class Model(
   val offers: List<Offer> = emptyList(),
   val tickets: List<Ticket> = emptyList(),
   val ticketsOffers: List<TicketOffer> = emptyList(),
    val loading: Boolean = false,
    val error: Boolean = false,
)