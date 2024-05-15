package com.myapp.tickets.data.repositoryImpl

import com.myapp.tickets.data.api.ApiService
import com.myapp.tickets.domain.dto.TicketOffer
import com.myapp.tickets.domain.error.ApiError
import com.myapp.tickets.domain.error.NetworkError
import com.myapp.tickets.domain.error.UnknownError
import com.myapp.tickets.domain.repository.ticketOffers.TicketOffersRepository
import java.io.IOException
import javax.inject.Inject


class TicketOffersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : TicketOffersRepository {
    override suspend fun getTicketsOffers(): List<TicketOffer> {
        try {
            val response = apiService.getTicketOffers()
            if (!response.isSuccessful) throw ApiError(response.code(), response.message())
            return response.body()?.tickets_offers ?: throw ApiError(response.code(), response.message())
        } catch (e:IOException){
            e.printStackTrace()
            throw NetworkError
        } catch (e: Exception) {
            e.printStackTrace()
            throw UnknownError
        }
    }
}