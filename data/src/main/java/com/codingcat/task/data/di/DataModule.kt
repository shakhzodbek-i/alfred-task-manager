package com.codingcat.task.data.di

import android.content.Context
import androidx.room.Room
import com.codingcat.task.data.repositories.local.TasksDatabase
import com.codingcat.task.data.repositories.remote.TaskManagerApi
import com.codingcat.task.data.utils.Constants.BASE_URL
import com.codingcat.task.data.utils.Constants.DATABASE_NAME
import com.skydoves.retrofit.adapters.arrow.EitherCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DataModule {

    @Singleton
    @Provides
    fun providesTasksDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, TasksDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providesTasksDao(
        database: TasksDatabase
    ) = database.tasksDao()

    @Singleton
    @Provides
    fun providesTaskManagerApi(): TaskManagerApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(EitherCallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TaskManagerApi::class.java)
    }
}