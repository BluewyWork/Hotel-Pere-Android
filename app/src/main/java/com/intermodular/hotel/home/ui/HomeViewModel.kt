package com.intermodular.hotel.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.home.data.model.HotelRoomModel
import com.intermodular.hotel.home.domain.GetAllHotelRoomsUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<HotelRoomModel>>()
    val hotelRooms: LiveData<List<HotelRoomModel>> = _hotelRooms

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