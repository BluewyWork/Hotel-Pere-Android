package com.intermodular.hotel.data.network

import com.intermodular.hotel.data.model.RoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomService @Inject constructor(private val api:RoomApiClient){
    suspend fun getRooms(): List<RoomModel>{
        return withContext(Dispatchers.IO){
            val response = api.getRooms()
            response.body() ?: emptyList()
        }
    }

}