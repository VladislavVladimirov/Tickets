package com.myapp.tickets.repository.tickets

import com.myapp.tickets.dto.Ticket

interface TicketsRepository {
    suspend fun getTickets():List<Ticket>
}