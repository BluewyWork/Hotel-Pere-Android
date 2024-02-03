package com.intermodular.hotel.data

import com.intermodular.hotel.data.model.HotelRoomModel
import com.intermodular.hotel.data.network.RoomService
import com.intermodular.hotel.domain.model.HotelRoom
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val api: RoomService,
    //private val roomDao: RoomDao
) {
    suspend fun getRoomsFromApi(): List<HotelRoom> {
        val response: List<HotelRoomModel> = api.getRooms()
        return response.map { it.toDomain() }
    }
    //Para Sqlite
    /*suspend fun getUserFromDataBase(): List<Room>{
        val response : List<RoomEntity> = RoomDao.getRooms()
        return response.map {it.toDomain()}

    }

    suspend fun insertRooms(rooms: List<RoomEntity>){
        roomDao.insertAll(rooms)
    }

    suspend fun clearRooms(){
        roomDao.clearRooms()
    }*/
}