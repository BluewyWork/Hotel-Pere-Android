package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.ReservationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReservationService @Inject constructor(
    private val api: ReservationApiClient
) {
    suspend fun getReservationListOfAuthenticatedCustomer(): List<ReservationModel> {
        return withContext(Dispatchers.IO) {
            try {
                api.getReservationListOfAuthenticatedCustomer()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            emptyList()
        }
    }
}