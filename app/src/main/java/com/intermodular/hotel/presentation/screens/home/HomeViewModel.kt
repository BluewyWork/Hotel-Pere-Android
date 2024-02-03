package com.intermodular.hotel.presentation.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetAllHotelRoomsUseCase
import com.intermodular.hotel.domain.model.HotelRoom
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<HotelRoom>>()
    val hotelRooms: LiveData<List<HotelRoom>> = _hotelRooms

    var getAllHotelRoomsUseCase = GetAllHotelRoomsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getAllHotelRoomsUseCase()

            if (result.isNotEmpty()) {
                _hotelRooms.postValue(result)
            }
        }
    }
}