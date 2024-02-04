package com.intermodular.hotel.data

import com.intermodular.hotel.data.network.ReservationService
import com.intermodular.hotel.domain.model.Reservation
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject

class ReservationRepository @Inject constructor(
    private val api: ReservationService
) {
    suspend fun getReservationListOfCustomer(): List<Reservation> {
        return api.getReservationListOfCustomer().map { it.toDomain() }
    }
}