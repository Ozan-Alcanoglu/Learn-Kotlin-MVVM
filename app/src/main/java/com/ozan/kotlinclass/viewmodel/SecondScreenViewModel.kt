package com.ozan.kotlinclass.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozan.kotlinclass.serviec.dto.JobDto
import com.ozan.kotlinclass.serviec.impl.JobImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SecondScreenViewModel @Inject constructor(
    private val jobService: JobImpl
) : ViewModel() {

    private val _operationStatus = MutableStateFlow<String>("")
    val operationStatus: StateFlow<String> get() = _operationStatus


    fun addJob(jobDto: JobDto) {
        viewModelScope.launch {
            try {
                jobService.addJob(jobDto)
                _operationStatus.value = "Job added successfully"
            } catch (e: Exception) {
                _operationStatus.value = "Error adding job: ${e.message}"
            }
        }
    }


    fun deleteJob(id: String) {
        viewModelScope.launch {
            try {
                jobService.deleteJob(id)
                _operationStatus.value = "Job deleted successfully"
            } catch (e: Exception) {
                _operationStatus.value = "Error deleting job: ${e.message}"
            }
        }
    }
}
