package com.myapp.tickets.domain.repository.draft

interface DraftRepository {
    fun saveDraft(content: String)
    fun getDraft(): String
}