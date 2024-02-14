package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.ReservationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReservationService @Inject constructor(
    private val reservationApi: ReservationApi
) {
    suspend fun getReservationListOfAuthenticatedGuestFromApi(): List<ReservationModel> {
        return withContext(Dispatchers.IO) {
            try {
                reservationApi.getReservationListOfAuthenticatedGuest()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            emptyList()
        }
    }

    suspend fun makeReservation(tokenFromGuest: String, roomNumber: Int): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = reservationApi.makeReservation(tokenFromGuest, roomNumber)

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