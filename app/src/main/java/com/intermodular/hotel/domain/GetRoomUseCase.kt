package com.intermodular.hotel.domain

import com.intermodular.hotel.data.RoomRepository
import com.intermodular.hotel.domain.model.Room
import javax.inject.Inject


class GetRoomUseCase  @Inject constructor(private val repository: RoomRepository) {
    suspend operator fun invoke(): List<Room> {
        val rooms = repository.getRoomsFromApi()
        return rooms

        /*return if (rooms.isNotEmpty()) {
            repository.clearRooms()
            repository.insertRooms(rooms.map {it.toDatabase()})
            rooms
        } else {
            repository.getRoomsFromDataBase()
        }*/
    }

}