package com.intermodular.hotel.data

import com.intermodular.hotel.data.database.dao.UserDao
import com.intermodular.hotel.data.database.entities.UserEntity
import com.intermodular.hotel.data.model.UserModel
import com.intermodular.hotel.data.network.UserService
import com.intermodular.hotel.domain.model.User
import com.intermodular.hotel.domain.model.toDomain
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
){
    suspend fun getUserFromApi(): List<User> {
        val response: List<UserModel> = api.getUser()
        return response.map {it.toDomain()}
    }
    suspend fun getUserFromDataBase(): List<User>{
        val response : List<UserEntity> = userDao.getUser()
        return response.map {it.toDomain()}

    }

    suspend fun insertUsers(users: List<UserEntity>){
        userDao.insertAll(users)
    }

    suspend fun clearUser(){
        userDao.clearUser()
    }
}