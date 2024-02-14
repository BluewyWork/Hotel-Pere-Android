package com.intermodular.hotel.data.network

object Endpoints {
    const val REGISTER_GUEST = "/auth/guest/register"
    const val LOGIN_GUEST = "/auth/guest/login"
    const val RETRIEVE_GUEST = "/guest/me"

    const val MAKE_RESERVATION = "/android/guest/reservation/new"
    const val CANCEL_RESERVATION = "/android/guest/reservation/cancel"
    const val RETRIVE_ALL_RESERVATIONS = "/android/guest/reservation/all"

    const val RETRIEVE_ALL_HOTEL_ROOMS = "/guest/room/all"
    const val RETRIEVE_ONE_HOTEL_ROOM = "/android/guest/room/one"
}