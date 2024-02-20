package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.MakeReservationModel
import com.intermodular.hotel.data.model.ReservationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReservationService @Inject constructor(
    private val reservationApi: ReservationApi
) {
    suspend fun getReservationListOfAuthenticatedGuestFromApi(token: String): List<ReservationModel> {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext reservationApi.getReservationListOfAuthenticatedGuest(token).data
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            emptyList()
        }
    }

    suspend fun makeReservation(
        tokenFromGuest: String,
        makeReservationModel: MakeReservationModel
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {

                return@withContext reservationApi.makeReservation(
                    tokenFromGuest,
                    makeReservationModel
                ).ok
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "RESERVATION ERROR: ${e.message}")

                false
            }
        }
    }
}