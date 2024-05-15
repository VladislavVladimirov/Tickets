package com.myapp.tickets.repository


import com.myapp.tickets.repository.draft.DraftRepository
import com.myapp.tickets.repository.draft.DraftRepositoryImpl
import com.myapp.tickets.repository.offers.OffersRepository
import com.myapp.tickets.repository.offers.OffersRepositoryImpl
import com.myapp.tickets.repository.tickets.TicketOffersRepository
import com.myapp.tickets.repository.tickets.TicketOffersRepositoryImpl
import com.myapp.tickets.repository.tickets.TicketsRepository
import com.myapp.tickets.repository.tickets.TicketsRepositoryImpl
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
