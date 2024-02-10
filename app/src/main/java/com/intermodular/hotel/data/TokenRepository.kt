package com.intermodular.hotel.data

import android.util.Log
import com.intermodular.hotel.data.database.dao.TokenDao
import com.intermodular.hotel.data.database.entities.TokenEntity
import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.data.network.TokenService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val tokenService: TokenService,
    private val tokenDao: TokenDao
) {
    suspend fun getGuestTokenFromApi(loginModel: LoginModel): String {
        return tokenService.getGuestTokenFromApi(loginModel)
    }

    suspend fun insertOneTokenToDatabase(tokenEntity: TokenEntity) {
        return withContext(Dispatchers.IO) {
            try {
                tokenDao.insertOne(tokenEntity)
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
        }
    }

    suspend fun getGuestTokenFromDatabase(): String {
        return withContext(Dispatchers.IO) {
            try {
                tokenDao.getOne().token
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
                ""
            }
        }
    }

    suspend fun clearAllTokensFromDatabase() {
        return withContext(Dispatchers.IO) {
            try {
                tokenDao.clearAll()
            } catch (e: Exception) {
                Log.e("LOOK AT ME", "${e.message}")
            }
        }
    }
}