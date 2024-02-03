package com.intermodular.hotel.domain

import com.intermodular.hotel.data.CustomerRepository
import com.intermodular.hotel.data.database.entities.toDatabase
import com.intermodular.hotel.domain.model.Customer
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: CustomerRepository) {
    suspend operator fun invoke(): List<Customer> {
        val users = repository.getCustomerFromApi()

        return if (users.isNotEmpty()) {
            repository.clearCustomer()
            repository.insertCustomer(users.map { it.toDatabase() })
            users
        } else {
            repository.getCustomerFromDataBase()
        }
    }
}