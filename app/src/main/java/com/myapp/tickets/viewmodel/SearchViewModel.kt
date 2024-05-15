package com.myapp.tickets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.tickets.model.Model
import com.myapp.tickets.repository.tickets.TicketOffersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: TicketOffersRepository
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
            val ticketsOffers = repository.getTicketsOffers()
            _data.value = Model(
                ticketsOffers = ticketsOffers
            )
        } catch (e: Exception) {
            _data.value = Model(error = true)
            e.printStackTrace()
        }
    }
}



