package com.ozan.kotlinclass.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "users")
data class User(

    @PrimaryKey
    val id:String=UUID.randomUUID().toString(),

    val username:String,

    val surname:String,

    val password:String

)


