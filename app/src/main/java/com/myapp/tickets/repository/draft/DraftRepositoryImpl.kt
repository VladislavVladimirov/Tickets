package com.myapp.tickets.repository.draft

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


    class DraftRepositoryImpl @Inject constructor(
        @ApplicationContext
        context: Context
    ) : DraftRepository {
        private val gson = Gson()
        private val prefs = context.getSharedPreferences("repo1", Context.MODE_PRIVATE)
        private val type = TypeToken.getParameterized(String::class.java).type

        private val key = "draft"

        private var draft = ""


        private val data = MutableLiveData(draft)

        init {
            prefs.getString(key, null)?.let {
                draft = gson.fromJson(it, type)
                data.value = draft
            }
        }

        override fun getDraft(): String {
            return draft
        }

        override fun saveDraft(content: String) {
            draft = content
            data.value = draft
            sync()
        }

        private fun sync() {
            with(prefs.edit()) {
                putString(key, gson.toJson(draft))
                apply()
            }
        }
    }
