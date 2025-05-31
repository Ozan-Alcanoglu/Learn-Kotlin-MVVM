package com.ozan.kotlinclass.repo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ozan.kotlinclass.model.Job

@Dao
interface JobDao {

    @Insert
    suspend fun addJob(job: Job)

    @Update
    suspend fun updateJob(job: Job)

    @Query("DELETE FROM job WHERE id= :id")
    suspend fun deleteJobById(id:String)
}
