package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.GuestModel
import com.intermodular.hotel.data.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GuestService @Inject constructor(private val guestApi: GuestApiClient) {
    suspend fun getAuthenticatedGuestFromApi(): GuestModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = guestApi.getOneGuest()
                response.body()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
            null
        }
    }

    suspend fun loginGuestFromApi(loginModel: LoginModel): String {
        return try {
            withContext(Dispatchers.IO) {
                val response = guestApi.loginGuest(loginModel)

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.ok) {
                        loginResponse.data.token
                    } else {
                        ""
                    }
                } else {
                    ""
                }
            }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "${e.message}")
            ""
        }
    }
}
