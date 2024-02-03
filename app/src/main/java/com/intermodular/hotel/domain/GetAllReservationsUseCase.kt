package com.intermodular.hotel.domain

import com.intermodular.hotel.data.model.ReservationModel
import java.util.Date
import javax.inject.Inject

class GetAllReservationsUseCase @Inject constructor(

) {
    suspend operator fun invoke(): List<ReservationModel> {
        return emptyList()
    }
}