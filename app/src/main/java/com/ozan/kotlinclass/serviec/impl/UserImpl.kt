package com.ozan.kotlinclass.serviec.impl

import com.ozan.kotlinclass.model.User
import com.ozan.kotlinclass.repo.UserDao
import com.ozan.kotlinclass.serviec.dto.UserDto
import javax.inject.Inject

class UserImpl@Inject constructor(

    private val userDao: UserDao
) {

    suspend fun addUser(userDto: UserDto){

        val user=User(
            username=userDto.username,
            password=userDto.password
        )
        userDao.addUser(user)

    }

    suspend fun deleteUser(id:String){

        userDao.deleteUserById(id)
    }

}
