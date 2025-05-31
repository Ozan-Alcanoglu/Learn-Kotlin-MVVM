package com.ozan.kotlinclass.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "job")
data class Job(

    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    val jobfield:String,

    val joblvl: Joblvl

)
