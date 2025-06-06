package com.ozan.kotlinclass.serviec.impl

import com.ozan.kotlinclass.repo.JobDao
import com.ozan.kotlinclass.serviec.dto.JobDto
import com.ozan.kotlinclass.model.Job
import javax.inject.Inject

class JobImpl@Inject constructor(
    private val jobDao: JobDao
) {

    suspend fun addJob(jobDto: JobDto){

        val joblvl = jobDto.joblvl ?: throw IllegalArgumentException("Job level cannot be null")
        val job = Job(
            jobfield = jobDto.jobfield,
            joblvl = joblvl
        )
        jobDao.addJob(job)
    }

    suspend fun deleteJob(id:String){
        jobDao.deleteJobById(id)
    }
}
