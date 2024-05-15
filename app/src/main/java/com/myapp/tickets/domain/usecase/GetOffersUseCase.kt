package com.myapp.tickets.domain.usecase

import com.myapp.tickets.domain.dto.Offer
import com.myapp.tickets.domain.repository.offers.OffersRepository
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(private val offersRepository: OffersRepository) {
    suspend fun execute(): List<Offer> {
        return offersRepository.getOffers()
    }
}