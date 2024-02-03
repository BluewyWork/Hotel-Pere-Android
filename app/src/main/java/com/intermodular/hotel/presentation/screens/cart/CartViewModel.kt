package com.intermodular.hotel.presentation.screens.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intermodular.hotel.domain.model.HotelRoom

class CartViewModel : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<HotelRoom>>()
    val hotelRooms: LiveData<List<HotelRoom>> = _hotelRooms

    //    var getHotelRoomsUseCase = GetHotelRoomsUseCase()
    fun onCreate() {
//        viewModelScope.launch {
//            val result = getHotelRoomsUseCase()
//
//            if (result.isNotEmpty()) {
//                _hotelRooms.postValue(result)
//            }
//        }
    }
}
