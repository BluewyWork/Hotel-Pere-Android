package com.intermodular.hotel.presentation.screens.hotelRoomDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.domain.GetDetailsOfRoomUseCase
import com.intermodular.hotel.domain.MakeReservationUseCase
import com.intermodular.hotel.domain.model.HotelRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HotelRoomDetailsViewModel @Inject constructor(
    private val getDetailsOfRoomUseCase: GetDetailsOfRoomUseCase,
    private val makeReservationUseCase: MakeReservationUseCase
) : ViewModel() {
     val isReserved = MutableLiveData<Boolean>()

    private val _hotelRoom = MutableLiveData<HotelRoom>()
    val hotelRoom: LiveData<HotelRoom> = _hotelRoom

    private val _checkIn = MutableLiveData<LocalDate>()
    val checkIn: LiveData<LocalDate> = _checkIn

    private val _checkOut = MutableLiveData<LocalDate>()
    val checkOut: LiveData<LocalDate> = _checkOut

    fun onCheckInChange(checkIn: LocalDate) {
        _checkIn.postValue(checkIn)
    }

    fun onCheckOutChange(checkOut: LocalDate) {
        _checkOut.postValue(checkOut)
    }

    fun setCurrentHotelRoomNumber(roomNumber: Int) {
        viewModelScope.launch {
            val hotelRoom = getDetailsOfRoomUseCase.getDetailsOfRoom(roomNumber)

            _hotelRoom.postValue(hotelRoom)
        }
    }

    fun onDismissDialog() {
        isReserved.postValue(true)
    }

    fun onReservePress(navController: NavController) {
        viewModelScope.launch {
            val isLoggedIn = getDetailsOfRoomUseCase.isLoggedIn()

            if (!isLoggedIn) {
                navController.navigate(Destinations.Login.route)
                return@launch
            }

            val checkIn = checkIn.value
            val checkOut = checkOut.value

            if (checkIn == null || checkOut == null) {
                return@launch
            }

            val hotelRoom = _hotelRoom.value ?: return@launch

            val success = makeReservationUseCase.makeReservation(
                hotelRoom = hotelRoom,
                checkIn = checkIn,
                checkOut = checkOut
            )

            if (!success) {

                isReserved.postValue(false)
                return@launch
            }

            
            navController.navigate(Destinations.ReservationsOverview.route)
        }
    }
}