package com.intermodular.hotel.data.network

object Endpoints {
    const val REGISTER_GUEST = "/auth/guest/register"
    const val LOGIN_GUEST = "/auth/guest/login"
    const val RETRIEVE_GUEST = "/guest/tableGuest/me"
    const val UPDATE_GUEST = "/guest/tableGuest/update"
    const val DELETE_GUEST = "/guest/tableGuest/delete"

    const val MAKE_RESERVATION = "/guest/reservation/new/{roomNumber}"
    const val CANCEL_RESERVATION = "/android/guest/reservation/cancel"
    const val RETRIVE_ALL_RESERVATIONS = "/android/guest/reservation/all"

    const val RETRIEVE_ALL_HOTEL_ROOMS = "/public/room/all"
    const val RETRIEVE_ONE_HOTEL_ROOM = "/public/room/show/{roomNumber}"
}