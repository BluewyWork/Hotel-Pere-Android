package com.intermodular.hotel.cart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.cart.data.model.HotelRoomModel
import com.intermodular.hotel.cart.domain.GetHotelRoomsUseCase
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<HotelRoomModel>>()
    val hotelRooms: LiveData<List<HotelRoomModel>> = _hotelRooms

    var getHotelRoomsUseCase = GetHotelRoomsUseCase()
    fun onCreate() {
        viewModelScope.launch {
            val result = getHotelRoomsUseCase()

            if (result.isNotEmpty()) {
                _hotelRooms.postValue(result)
            }
        }
    }
}
