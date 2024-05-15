package com.myapp.tickets.data.repositoryImpl

import com.myapp.tickets.data.api.ApiService
import com.myapp.tickets.domain.dto.Offer
import com.myapp.tickets.domain.error.ApiError
import com.myapp.tickets.domain.error.NetworkError
import com.myapp.tickets.domain.error.UnknownError
import com.myapp.tickets.domain.repository.offers.OffersRepository
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