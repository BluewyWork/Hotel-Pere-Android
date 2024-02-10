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
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    private val _hotelRoom = MutableLiveData<HotelRoom>()
    val hotelRoom: LiveData<HotelRoom> = _hotelRoom

    fun getHotelRoom(roomNumber: String?) {
        if (roomNumber.isNullOrBlank()) {
            return
        }

        val parsedRoomNumber = roomNumber.toIntOrNull() ?: return

        viewModelScope.launch {
            val x = getDetailsOfRoomUseCase.getDetailsOfRoom(parsedRoomNumber)
            _hotelRoom.postValue(x)
        }
    }

    fun onReservePress() {
        viewModelScope.launch {
            val isLoggedIn = getDetailsOfRoomUseCase.isLoggedIn()
            _isLoggedIn.postValue(isLoggedIn)

            if (!isLoggedIn) {
                return@launch
            }

            val hotelRoom = _hotelRoom.value ?: return@launch

            makeReservationUseCase.makeReservation(hotelRoom)
        }
    }
}