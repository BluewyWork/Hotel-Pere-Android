package com.intermodular.hotel.domain

import com.intermodular.hotel.data.model.ReservationModel
import java.util.Date

class GetAllReservationsUseCase {
    suspend operator fun invoke(): List<ReservationModel> {
        return emptyList()
    }
}