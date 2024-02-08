package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.TokenDao
import com.intermodular.hotel.data.database.entities.TokenEntity
import com.intermodular.hotel.data.model.LoginModel
import com.intermodular.hotel.data.network.TokenService
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val tokenService: TokenService,
    private val tokenDao: TokenDao
) {
    suspend fun getGuestTokenFromApi(loginModel: LoginModel): String {
        return tokenService.getGuestTokenFromApi(loginModel)
    }

    suspend fun insertOneTokenToDatabase(tokenEntity: TokenEntity) {
        tokenDao.insertOne(tokenEntity)
    }

    suspend fun clearAllTokensFromDatabase() {
        tokenDao.clearAll()
    }
}