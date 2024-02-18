package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.MakeReservationModel
import com.intermodular.hotel.data.model.ReservationDates
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

    suspend fun makeReservation(
        tokenFromGuest: String,
        makeReservationModel: MakeReservationModel
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response =
                    reservationApi.makeReservation(tokenFromGuest, makeReservationModel)

                if (!response.ok) {
                    Log.e("LOOK AT ME", response.data)
                }

                response.ok
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "RESERVATION ERROR: ${e.message}")

                false
            }
        }
    }
}