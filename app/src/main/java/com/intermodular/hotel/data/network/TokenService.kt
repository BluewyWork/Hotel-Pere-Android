package com.intermodular.hotel.data.network

import android.util.Log
import com.intermodular.hotel.data.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenService @Inject constructor(
    private val tokenApi: TokenApi
) {
    suspend fun getGuestTokenFromApi(loginModel: LoginModel): String {
        return try {
            withContext(Dispatchers.IO) {
                val tokenResponse = tokenApi.getGuestToken(loginModel)

                if (!tokenResponse.isSuccessful) {
                    return@withContext ""
                }

                val tokenResponseBody = tokenResponse.body()

                if (tokenResponseBody == null || !tokenResponseBody.ok) {
                    return@withContext ""
                }

                tokenResponseBody.data.token
            }
        } catch (e: Exception) {
            Log.e("LOOK AT ME", "${e.message}")
            return ""
        }
    }
}