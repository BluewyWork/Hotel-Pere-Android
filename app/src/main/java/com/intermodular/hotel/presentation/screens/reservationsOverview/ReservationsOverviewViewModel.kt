package com.intermodular.hotel.presentation.screens.reservationsOverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.data.model.ReservationModel
import com.intermodular.hotel.domain.GetAllReservationsUseCase
import kotlinx.coroutines.launch

class ReservationsOverviewViewModel : ViewModel() {
    private val _reservations = MutableLiveData<List<ReservationModel>>()
    val reservations: LiveData<List<ReservationModel>> = _reservations
    fun onCreate() {
        viewModelScope.launch {
            val getAllReservationsUseCase = GetAllReservationsUseCase()

            _reservations.postValue(getAllReservationsUseCase.invoke())
        }
    }
}