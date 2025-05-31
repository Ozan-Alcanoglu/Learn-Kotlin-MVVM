package com.ozan.kotlinclass.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozan.kotlinclass.serviec.dto.JobDto
import com.ozan.kotlinclass.serviec.dto.UserDto
import com.ozan.kotlinclass.serviec.impl.JobImpl;
import com.ozan.kotlinclass.serviec.impl.UserImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject;

@HiltViewModel
class SharedDosyaViewModel @Inject constructor(
    private val jobService: JobImpl,
    private val userService: UserImpl
) : ViewModel() {

    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var password by mutableStateOf("")

    fun saveUserData(first: String, last: String, pass: String) {
        firstName = first
        lastName = last
        password = pass
    }

    private val _operationStatus = MutableStateFlow<String>("")
    val operationStatus: StateFlow<String> get() = _operationStatus

    suspend fun addUser(userDto: UserDto){

            try {

                userService.addUser(userDto)
                _operationStatus.value = "User added successfully"
            } catch (e: Exception) {
                _operationStatus.value = "Error adding user: ${e.message}"
            }

    }

    suspend fun addJob(jobDto: JobDto) {

            try {
                jobService.addJob(jobDto)
                _operationStatus.value = "Job added successfully"
            } catch (e: Exception) {
                _operationStatus.value = "Error adding job: ${e.message}"
            }

    }
}


