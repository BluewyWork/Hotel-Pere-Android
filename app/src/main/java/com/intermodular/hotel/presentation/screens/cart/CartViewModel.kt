package com.intermodular.hotel.presentation.screens.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.model.Room
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<Room>>()
    val hotelRooms: LiveData<List<Room>> = _hotelRooms

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
