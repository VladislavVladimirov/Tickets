package com.myapp.tickets.repository.tickets

import com.myapp.tickets.api.ApiService
import com.myapp.tickets.dto.Ticket
import com.myapp.tickets.error.ApiError
import com.myapp.tickets.error.NetworkError
import com.myapp.tickets.error.UnknownError
import java.io.IOException
import javax.inject.Inject


class TicketsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : TicketsRepository {
    override suspend fun getTickets(): List<Ticket> {
        try {
            val response = apiService.getTickets()
            if (!response.isSuccessful) throw ApiError(response.code(), response.message())
            return response.body()?.tickets ?: throw ApiError(response.code(), response.message())
        } catch (e: IOException) {
            e.printStackTrace()
            throw NetworkError
        } catch (e: Exception) {
            e.printStackTrace()
            throw UnknownError
        }
    }
}