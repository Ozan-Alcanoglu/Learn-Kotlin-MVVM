package com.ozan.kotlinclass.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozan.kotlinclass.model.User
import com.ozan.kotlinclass.repo.UserDao
import com.ozan.kotlinclass.serviec.dto.UserDto
import com.ozan.kotlinclass.serviec.impl.UserImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstScreenViewModel @Inject constructor(
    private val userImpl: UserImpl
):ViewModel() {

    private val _operationStatus = MutableStateFlow<String>("")
    val operationStatus: StateFlow<String> get() = _operationStatus

    suspend fun addUser(userDto: UserDto){

        viewModelScope.launch {
            try {

                userImpl.addUser(userDto)
                _operationStatus.value = "User added successfully"
            } catch (e: Exception) {
                _operationStatus.value = "Error adding user: ${e.message}"
            }
        }
    }


    suspend fun deleteUser(id:String){
        try {
            userImpl.deleteUser(id)
            _operationStatus.value="User deleted successfully"
        }
        catch (e:Exception){
            _operationStatus.value="Error delete user: ${e.message}"
        }
    }

}
