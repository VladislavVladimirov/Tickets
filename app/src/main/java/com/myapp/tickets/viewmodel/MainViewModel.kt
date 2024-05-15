package com.myapp.tickets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.tickets.model.Model
import com.myapp.tickets.repository.draft.DraftRepository
import com.myapp.tickets.repository.offers.OffersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: OffersRepository,
    private val draftRepository: DraftRepository
) : ViewModel() {

    private val _data = MutableLiveData(Model())
    val data: LiveData<Model>
        get() = _data
    init {
        loadData()
    }
    private fun loadData() = viewModelScope.launch {
        try {
            _data.value = Model(loading = true)
            val offers = repository.getOffers()
            _data.value = Model(
                offers = offers
            )
        } catch (e: Exception) {
            _data.value = Model(error = true)
            e.printStackTrace()
        }
    }
   fun getDraft(): String {
        return draftRepository.getDraft()
    }
    fun saveDraft(text: String) {
        draftRepository.saveDraft(text)
    }
}



