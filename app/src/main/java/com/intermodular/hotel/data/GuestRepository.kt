package com.intermodular.hotel.data

import android.util.Log
import com.intermodular.hotel.data.database.dao.GuestDao
import com.intermodular.hotel.data.database.entities.toDatabase
import com.intermodular.hotel.data.model.GuestModel
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
        return try {
            api.getAuthenticatedGuestFromApi(token)?.toDomain()
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "ERROR: ${e.message}")
            null
        }
    }

    suspend fun registerGuestToApi(
        name: String,
        surname: String,
        email: String,
    ): Boolean {
        val guestModel = GuestModel(
            name = name,
            surname = surname,
            email = email,
        )

        return api.registerGuestToApi(guestModel)
    }

    suspend fun getAuthenticatedGuestFromDataBase(): Guest? {
        return withContext(Dispatchers.IO) {
            try {
                guestDao.getAuthenticatedGuest()?.toDomain()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
                null
            }
        }
    }

    suspend fun insertOneGuestToDatabase(guest: Guest) {
        return withContext(Dispatchers.IO) {
            try {
                guestDao.insertOne(guest.toDatabase())
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
        }
    }

    suspend fun clearGuestFromDatabase() {
        return withContext(Dispatchers.IO) {
            try {
                guestDao.clearAll()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
        }
    }
}