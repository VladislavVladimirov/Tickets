package com.myapp.tickets.repository.draft

interface DraftRepository {
    fun saveDraft(content: String)
    fun getDraft(): String
}