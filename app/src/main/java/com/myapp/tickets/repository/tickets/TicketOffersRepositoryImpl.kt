package com.myapp.tickets.repository.tickets

import com.myapp.tickets.api.ApiService
import com.myapp.tickets.dto.TicketOffer
import com.myapp.tickets.error.ApiError
import com.myapp.tickets.error.NetworkError
import com.myapp.tickets.error.UnknownError
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