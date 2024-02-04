package com.intermodular.hotel.domain

import com.intermodular.hotel.data.RoomRepository
import com.intermodular.hotel.domain.model.HotelRoom
import javax.inject.Inject

class GetHotelRoomListUseCase @Inject constructor(
    private val repository: RoomRepository
) {
    suspend operator fun invoke(): List<HotelRoom> {
        return repository.getHotelRoomListFromApi()
    }
}