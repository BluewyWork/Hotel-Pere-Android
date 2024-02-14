package com.intermodular.hotel.presentation.screens.hotelRoomDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetDetailsOfRoomUseCase
import com.intermodular.hotel.domain.MakeReservationUseCase
import com.intermodular.hotel.domain.model.HotelRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelRoomDetailsViewModel @Inject constructor(
    private val getDetailsOfRoomUseCase: GetDetailsOfRoomUseCase,
    private val makeReservationUseCase: MakeReservationUseCase
) : ViewModel() {
    private val _hotelRoom = MutableLiveData<HotelRoom>()
    val hotelRoom: LiveData<HotelRoom> = _hotelRoom

    fun setCurrentHotelRoomNumber(roomNumber: Int) {
        viewModelScope.launch {
            val hotelRoom = getDetailsOfRoomUseCase.getDetailsOfRoom(roomNumber)

            _hotelRoom.postValue(hotelRoom)
        }
    }

    fun onReservePress() {
        viewModelScope.launch {
            val isLoggedIn = getDetailsOfRoomUseCase.isLoggedIn()

            if (!isLoggedIn) {
                return@launch
            }

            val hotelRoom = _hotelRoom.value ?: return@launch

            makeReservationUseCase.makeReservation(hotelRoom)
        }
    }
}