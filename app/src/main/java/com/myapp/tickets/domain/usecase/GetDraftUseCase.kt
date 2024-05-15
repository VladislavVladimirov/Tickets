package com.myapp.tickets.domain.usecase

import com.myapp.tickets.domain.repository.draft.DraftRepository
import javax.inject.Inject

class GetDraftUseCase @Inject constructor(private val draftRepository: DraftRepository) {
    fun execute(): String {
        return draftRepository.getDraft()
    }
}