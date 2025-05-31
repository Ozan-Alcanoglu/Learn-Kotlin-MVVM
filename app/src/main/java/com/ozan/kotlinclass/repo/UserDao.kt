package com.ozan.kotlinclass.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ozan.kotlinclass.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM users WHERE id=:id")
    suspend fun  deleteUserById(id:String)

}
