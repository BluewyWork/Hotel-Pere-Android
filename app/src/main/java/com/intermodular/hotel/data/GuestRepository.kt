package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.GuestDao
import com.intermodular.hotel.data.database.entities.GuestEntity
import com.intermodular.hotel.data.network.GuestService
import com.intermodular.hotel.domain.model.Guest
import com.intermodular.hotel.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GuestRepository @Inject constructor(
    private val api: GuestService,
    private val guestDao: GuestDao
) {
    suspend fun getAuthenticatedGuestFromApi(token: String): Guest? {
        return api.getAuthenticatedGuestFromApi(token)?.toDomain()
    }

    suspend fun getAuthenticatedGuestFromDataBase(): Guest? {
        return withContext(Dispatchers.IO) {
            guestDao.getAuthenticatedGuest()?.toDomain()
        }
    }

    suspend fun insertOneGuestToDatabase(guest: GuestEntity) {
        guestDao.insertOne(guest)
    }

    suspend fun clearGuestFromDatabase() {
        guestDao.clearAll()
    }
}