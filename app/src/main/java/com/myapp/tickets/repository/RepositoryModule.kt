package com.myapp.tickets.repository


import com.myapp.tickets.repository.draft.DraftRepository
import com.myapp.tickets.repository.draft.DraftRepositoryImpl
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
    fun bindsRepository(impl: RepositoryImpl): Repository
    @Singleton
    @Binds
    fun bindsDraftRepository(impl: DraftRepositoryImpl): DraftRepository
}
