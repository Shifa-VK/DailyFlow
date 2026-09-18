package com.example.dailyflow.di

import android.content.Context
import androidx.room.Room
import com.example.dailyflow.data.local.TaskDao
import com.example.dailyflow.data.local.TaskDatabase
import com.example.dailyflow.data.repository.TaskRepositoryImpl
import com.example.dailyflow.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "dailyflow_database"
        ).build()
    }

    @Provides
    fun provideTaskDao(
        database: TaskDatabase
    ): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(
        taskDao: TaskDao
    ): TaskRepository {
        return TaskRepositoryImpl(taskDao)
    }
}