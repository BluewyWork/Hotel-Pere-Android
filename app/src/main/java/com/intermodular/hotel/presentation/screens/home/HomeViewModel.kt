package com.intermodular.hotel.presentation.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetHotelRoomListUseCase
import com.intermodular.hotel.domain.model.HotelRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHotelRoomListUseCase: GetHotelRoomListUseCase,
) : ViewModel() {
    private val _hotelRooms = MutableLiveData<List<HotelRoom>>()
    val hotelRooms: LiveData<List<HotelRoom>> = _hotelRooms

    fun onCreate() {
        viewModelScope.launch {
            val result = getHotelRoomListUseCase()

            if (result.isNotEmpty()) {
                _hotelRooms.postValue(result)
            }
        }
    }
}