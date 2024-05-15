package com.myapp.tickets.repository.offers

import com.myapp.tickets.api.ApiService
import com.myapp.tickets.dto.Offer
import com.myapp.tickets.error.ApiError
import com.myapp.tickets.error.NetworkError
import com.myapp.tickets.error.UnknownError
import java.io.IOException
import javax.inject.Inject


class OffersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : OffersRepository {
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
}