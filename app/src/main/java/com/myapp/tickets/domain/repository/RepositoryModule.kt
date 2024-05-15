package com.myapp.tickets.domain.repository


import com.myapp.tickets.domain.repository.draft.DraftRepository
import com.myapp.tickets.data.repositoryImpl.DraftRepositoryImpl
import com.myapp.tickets.domain.repository.offers.OffersRepository
import com.myapp.tickets.data.repositoryImpl.OffersRepositoryImpl
import com.myapp.tickets.domain.repository.ticketOffers.TicketOffersRepository
import com.myapp.tickets.data.repositoryImpl.TicketOffersRepositoryImpl
import com.myapp.tickets.domain.repository.tickets.TicketsRepository
import com.myapp.tickets.data.repositoryImpl.TicketsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindsOffersRepository(impl: OffersRepositoryImpl): OffersRepository

    @Singleton
    @Binds
    fun bindsDraftRepository(impl: DraftRepositoryImpl): DraftRepository

    @Singleton
    @Binds
    fun bindsTicketsRepository(impl: TicketsRepositoryImpl): TicketsRepository

    @Singleton
    @Binds
    fun bindsTicketOffersRepository(impl: TicketOffersRepositoryImpl): TicketOffersRepository
}
