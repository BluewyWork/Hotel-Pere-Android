package com.intermodular.hotel.presentation.screens.reservationsOverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetReservationListOfGuestUseCase
import com.intermodular.hotel.domain.model.Reservation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReservationsOverviewViewModel @Inject constructor(
    private val getReservationListOfGuestUseCase: GetReservationListOfGuestUseCase
) : ViewModel() {
    private val _reservations = MutableLiveData<List<Reservation>>()
    val reservations: LiveData<List<Reservation>> = _reservations
    fun onCreate() {
        viewModelScope.launch {

            _reservations.postValue(getReservationListOfGuestUseCase())
        }
    }
}