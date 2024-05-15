package com.myapp.tickets.domain.repository.tickets

import com.myapp.tickets.domain.dto.Ticket

interface TicketsRepository {
    suspend fun getTickets():List<Ticket>
}