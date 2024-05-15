package com.myapp.tickets.domain.usecase

import com.myapp.tickets.domain.repository.draft.DraftRepository
import javax.inject.Inject

class SetDraftUseCase @Inject constructor(private val draftRepository: DraftRepository) {
    fun execute(content: String) {
        draftRepository.saveDraft(content)
    }
}