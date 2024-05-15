package com.myapp.tickets.domain.usecase

import com.myapp.tickets.domain.dto.Ticket
import com.myapp.tickets.domain.repository.tickets.TicketsRepository
import javax.inject.Inject

class GetTicketsUseCase @Inject constructor(private val ticketsRepository: TicketsRepository) {
    suspend fun execute(): List<Ticket> {
        return ticketsRepository.getTickets()
    }
}