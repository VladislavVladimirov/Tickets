package com.myapp.tickets.repository.offers

import com.myapp.tickets.dto.Offer

interface OffersRepository {
    suspend fun getOffers():List<Offer>
}