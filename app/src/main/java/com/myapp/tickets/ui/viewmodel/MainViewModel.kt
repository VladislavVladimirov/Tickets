package com.myapp.tickets.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.tickets.domain.model.Model
import com.myapp.tickets.domain.usecase.GetDraftUseCase
import com.myapp.tickets.domain.usecase.GetOffersUseCase
import com.myapp.tickets.domain.usecase.SetDraftUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDraftUseCase: GetDraftUseCase,
    private val setDraftUseCase: SetDraftUseCase,
    private val getOffersUseCase: GetOffersUseCase
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
            val offers = getOffersUseCase.execute()
            _data.value = Model(
                offers = offers
            )
        } catch (e: Exception) {
            _data.value = Model(error = true)
            e.printStackTrace()
        }
    }
   fun getDraft(): String {
        return getDraftUseCase.execute()
    }
    fun saveDraft(text: String) {
        setDraftUseCase.execute(text)
    }
}



