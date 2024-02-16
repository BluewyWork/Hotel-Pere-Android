package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.GuestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GuestService @Inject constructor(
    private val guestApi: GuestApi
) {
    suspend fun getAuthenticatedGuestFromApi(token: String): GuestModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = guestApi.retrieveGuest(token)

                if (!response.ok) {
                    Log.e("LOOK AT ME", "API RESPONSE: NOT OK")
                }
                return@withContext response.data
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
                return@withContext null
            }
        }
    }

    suspend fun registerGuestToApi(guestModel: GuestModel): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = guestApi.registerGuest(guestModel)

                if (!response.isSuccessful) {
                    return@withContext false
                }

                return@withContext response.body()?.ok ?: false
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")

                false
            }
        }
    }
}
