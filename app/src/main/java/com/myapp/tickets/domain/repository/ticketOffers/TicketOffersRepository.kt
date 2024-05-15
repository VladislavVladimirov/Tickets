package com.myapp.tickets.domain.repository.ticketOffers

import com.myapp.tickets.domain.dto.TicketOffer

interface TicketOffersRepository {
    suspend fun getTicketsOffers():List<TicketOffer>
}