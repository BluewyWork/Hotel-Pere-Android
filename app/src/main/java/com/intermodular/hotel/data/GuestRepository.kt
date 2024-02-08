package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.GuestDao
import com.intermodular.hotel.data.database.entities.GuestEntity
import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.model.LoginModel
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
    suspend fun getAuthenticatedGuestFromApi(): Guest? {
        val response: GuestModel? = api.getAuthenticatedGuestFromApi()
        return response?.toDomain()
    }

    suspend fun getAuthenticatedGuestFromDataBase(): Guest? {
        return withContext(Dispatchers.IO) {
            guestDao.getAuthenticatedGuest()?.toDomain()
        }
    }

    suspend fun loginGuestFromApi(loginModel: LoginModel): String {
        return api.loginGuestFromApi(loginModel)
    }

    suspend fun insertOneGuest(guest: GuestEntity) {
        guestDao.insertOne(guest)
    }

    suspend fun clearGuest() {
        guestDao.clearAll()
    }
}