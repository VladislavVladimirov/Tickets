package com.myapp.tickets.repository

import com.myapp.tickets.dto.Offer
import com.myapp.tickets.dto.Ticket
import com.myapp.tickets.dto.TicketOffer

interface Repository {
    suspend fun getOffers():List<Offer>
    suspend fun getTickets():List<Ticket>
    suspend fun getTicketsOffers():List<TicketOffer>
}