package com.myapp.tickets.domain.repository.offers

import com.myapp.tickets.domain.dto.Offer

interface OffersRepository {
    suspend fun getOffers():List<Offer>
}