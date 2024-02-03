package com.intermodular.hotel.domain

import com.intermodular.hotel.data.UserRepository
import com.intermodular.hotel.data.database.entities.toDatabase
import com.intermodular.hotel.domain.model.Customer
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(): List<Customer> {
        val users = repository.getUserFromApi()

        return if (users.isNotEmpty()) {
            repository.clearUser()
            repository.insertUsers(users.map { it.toDatabase() })
            users
        } else {
            repository.getUserFromDataBase()
        }
    }

}