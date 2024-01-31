package com.intermodular.hotel.perfil.ui

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {
    private val _profileIcon = MutableLiveData<Image>()
    val profileIcon: LiveData<Image> = _profileIcon

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> = _nombre

    private val _apellidos = MutableLiveData<String>()
    val apellidos: LiveData<String> = _apellidos


    private val _numeroDeTelefono = MutableLiveData<String>()
    val numeroDeTelefono: LiveData<String> = _numeroDeTelefono

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email


}