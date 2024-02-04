package com.intermodular.hotel.domain

import com.intermodular.hotel.data.CustomerRepository
import com.intermodular.hotel.data.database.entities.toDatabase
import com.intermodular.hotel.domain.model.Customer
import javax.inject.Inject

class GetCustomerUseCase @Inject constructor(private val repository: CustomerRepository) {
    suspend operator fun invoke(): Customer? {
        val customerFromApi = repository.getCustomerFromApi()

        return if (customerFromApi != null) {
            repository.clearCustomer()
            repository.insertCustomer(customerFromApi.toDatabase())
            customerFromApi
        } else {
            val customerFromDatabase = repository.getCustomerFromDataBase()

            if (customerFromDatabase != null) {
                return customerFromDatabase
            }

            generateCustomer()
        }
    }

    suspend fun generateCustomer(): Customer {
        val name = "John"
        val surname = "Doe"
        val email = "john.doe@example.com"
        val token = "239tn_3nus3t4ner3o"

        return Customer(name, surname, email, token)
    }
}