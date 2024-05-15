package com.myapp.tickets.repository.tickets

import com.myapp.tickets.dto.TicketOffer

interface TicketOffersRepository {
    suspend fun getTicketsOffers():List<TicketOffer>
}