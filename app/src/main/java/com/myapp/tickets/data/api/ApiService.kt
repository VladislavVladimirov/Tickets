package com.myapp.tickets.data.api

import com.myapp.tickets.domain.dto.response.OffersResponse
import com.myapp.tickets.domain.dto.response.TicketOffersResponse
import com.myapp.tickets.domain.dto.response.TicketsResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav&export=download")
    suspend fun getOffers(): Response<OffersResponse>

    @GET("uc?id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta&export=download")
    suspend fun getTicketOffers(): Response<TicketOffersResponse>

    @GET("uc?id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA&export=download")
    suspend fun getTickets(): Response<TicketsResponse>
}


