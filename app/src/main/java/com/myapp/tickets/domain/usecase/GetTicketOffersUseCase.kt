package com.myapp.tickets.domain.usecase

import com.myapp.tickets.domain.dto.TicketOffer
import com.myapp.tickets.domain.repository.ticketOffers.TicketOffersRepository
import javax.inject.Inject

class GetTicketOffersUseCase @Inject constructor(private val ticketOffersRepository: TicketOffersRepository) {
    suspend fun execute(): List<TicketOffer> {
        return ticketOffersRepository.getTicketsOffers()
    }
}