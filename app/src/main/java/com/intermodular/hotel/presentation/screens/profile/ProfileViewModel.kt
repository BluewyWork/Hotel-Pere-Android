package com.intermodular.hotel.presentation.screens.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.intermodular.hotel.core.navigations.Destinations
import com.intermodular.hotel.domain.DeleteGuestUseCase
import com.intermodular.hotel.domain.GetAuthenticatedGuestUseCase
import com.intermodular.hotel.domain.GuestUseCase
import com.intermodular.hotel.domain.UpdateGuestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAuthenticatedGuestUseCase: GetAuthenticatedGuestUseCase,
    private val guestUseCase: GuestUseCase,
    private val deleteGuestUseCase: DeleteGuestUseCase,
    private val updateGuestUseCase: UpdateGuestUseCase
) : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    val _userUpdated = MutableLiveData<Boolean>()
    val userUpdated: LiveData<Boolean> = _userUpdated

    private val _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onUsernameChange(name: String) {
        _name.postValue(name)
    }

    fun onLastNameChange(surname: String) {
        _surname.postValue(surname)
    }

    fun onEmailChange(email: String) {
        _email.postValue(email)
    }

    fun onDismissAlert() {
        _userUpdated.postValue(false)
    }

    fun loadData(navController: NavController) {
        viewModelScope.launch {
            val loggedIn = guestUseCase.isLoggedIn()

            if (!loggedIn) {
                navController.navigate(Destinations.Login.route)
            }

            val guest = getAuthenticatedGuestUseCase() ?: return@launch

            _name.postValue(guest.name)
            _surname.postValue(guest.surname)
            _email.postValue(guest.email)
        }
    }
    fun onDeleteAccountPress(navController: NavController) {
        viewModelScope.launch {
            if (deleteGuestUseCase.deleteGuest()) {
                navController.navigate(Destinations.Login.route)
            }
        }
    }

    fun onUpdatePress() {
        viewModelScope.launch {
            val name = _name.value ?: return@launch
            val surname = _surname.value ?: return@launch
            val email = _email.value ?: return@launch

            Log.d("LOOK AT ME", "name: $name, surname: $surname, email: $email")

            if (updateGuestUseCase.updateGuest(name, surname, email)) {
                _userUpdated.postValue(true)
            }
        }

    }
}