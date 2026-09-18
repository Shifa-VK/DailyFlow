package com.example.dailyflow.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyflow.data.local.TaskEntity
import com.example.dailyflow.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    private val _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val tasks: StateFlow<List<TaskEntity>> = _tasks.asStateFlow()

    init {
        observeTasks()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            combine(
                repository.getAllTasks(),
                searchQuery
            ) { tasks, query ->
                if (query.isBlank()) {
                    tasks
                } else {
                    tasks.filter {
                        it.title.contains(query, ignoreCase = true)
                    }
                }
            }.collect {
                _tasks.value = it
            }
        }
    }

    fun search(query: String) {
        searchQuery.value = query
    }

    fun addTask(title: String, priority: String) {
        if (title.isBlank()) return

        viewModelScope.launch {
            repository.insertTask(
                TaskEntity(
                    title = title,
                    priority = priority
                )
            )
        }
    }

    fun toggleTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.updateTask(
                task.copy(isCompleted = !task.isCompleted)
            )
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}