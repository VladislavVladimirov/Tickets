package com.myapp.tickets.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.tickets.domain.model.Model
import com.myapp.tickets.domain.usecase.GetTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketsViewModel @Inject constructor(
    private val getTicketsUseCase: GetTicketsUseCase
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
            val tickets = getTicketsUseCase.execute()
            _data.value = Model(
                tickets = tickets
            )
        } catch (e: Exception) {
            _data.value = Model(error = true)
            e.printStackTrace()
        }
    }
}



