package com.intermodular.hotel.carrito.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarritoViewModel : ViewModel() {
    private val _items = MutableLiveData<HashMap<String, HashMap<String, Int>>>()
    val items: LiveData<HashMap<String, HashMap<String, Int>>> = _items

    private val _itemsTotalCost = MutableLiveData<Double>()
    val itemsTotalCost: LiveData<Double> = _itemsTotalCost

    fun generateSampleData() {
        val superItems: HashMap<String, HashMap<String, Int>> = HashMap()
        val items: HashMap<String, Int> = HashMap()
        items["Habitacion 1"] = 50
        items["Habitacion 2"] = 150
        items["Habitacion 3"] = 250
        items["Habitacion 4"] = 350
        items["Habitacion 5"] = 450
        superItems["Set 1"] = items

        val items2: HashMap<String, Int> = HashMap()
        items2["Habitacion 1"] = 50
        items2["Habitacion 2"] = 150
        items2["Habitacion 3"] = 250
        items2["Habitacion 4"] = 350
        items2["Habitacion 5"] = 450

        val items3: HashMap<String, Int> = HashMap()
        items3["Habitacion 1"] = 50
        items3["Habitacion 2"] = 150
        items3["Habitacion 3"] = 250
        items3["Habitacion 4"] = 350
        items3["Habitacion 5"] = 450

        superItems["Set 2"] = items2
        superItems["Set 3"] = items3

        _items.value = superItems

        var totalCost: Double = 0.0
        for ((_, itemsMini) in superItems) {
            var subtotal = 0

            for ((_, value) in itemsMini) {
                subtotal += value
            }

            totalCost += subtotal
        }

        _itemsTotalCost.value = totalCost
    }
}
