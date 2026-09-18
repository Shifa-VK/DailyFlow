package com.example.dailyflow.domain.repository

import com.example.dailyflow.data.local.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getAllTasks(): Flow<List<TaskEntity>>

    suspend fun insertTask(task: TaskEntity)

    suspend fun updateTask(task: TaskEntity)

    suspend fun deleteTask(task: TaskEntity)
}