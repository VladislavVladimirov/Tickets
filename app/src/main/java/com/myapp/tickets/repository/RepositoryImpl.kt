package com.myapp.tickets.repository

import com.myapp.tickets.api.ApiService
import com.myapp.tickets.dto.Offer
import com.myapp.tickets.dto.Ticket
import com.myapp.tickets.dto.TicketOffer
import com.myapp.tickets.error.ApiError
import com.myapp.tickets.error.NetworkError
import com.myapp.tickets.error.UnknownError
import java.io.IOException
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : Repository {
    override suspend fun getOffers(): List<Offer> {
        try {
            val response = apiService.getOffers()
            if (!response.isSuccessful) throw ApiError(response.code(), response.message())
            return response.body()?.offers ?: throw ApiError(response.code(), response.message())
        } catch (e: IOException){
            e.printStackTrace()
            throw NetworkError
        } catch (e: Exception) {
            e.printStackTrace()
            throw UnknownError
        }
    }

    override suspend fun getTickets(): List<Ticket> {
        try {
            val response = apiService.getTickets()
            if (!response.isSuccessful) throw ApiError(response.code(), response.message())
            return response.body()?.tickets ?: throw ApiError(response.code(), response.message())
        } catch (e:IOException){
            e.printStackTrace()
            throw NetworkError
        } catch (e: Exception) {
            e.printStackTrace()
            throw UnknownError
        }
    }

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