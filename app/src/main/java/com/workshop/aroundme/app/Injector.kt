package com.workshop.aroundme.app

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.workshop.aroundme.data.repository.CategoryRepository
import com.workshop.aroundme.data.repository.PlaceRepository
import com.workshop.aroundme.data.repository.UserRepository
import com.workshop.aroundme.local.AppDatabase
import com.workshop.aroundme.local.datasource.PlaceLocalDataSource
import com.workshop.aroundme.local.datasource.UserLocalDataSource
import com.workshop.aroundme.remote.NetworkManager
import com.workshop.aroundme.remote.datasource.CategoryRemoteDataSource
import com.workshop.aroundme.remote.datasource.PlaceRemoteDataSource
import com.workshop.aroundme.remote.service.CategoryService
import com.workshop.aroundme.remote.service.PlaceService

object Injector {

    private fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db.data").build()
    }

    fun provideCategoryRepository(requireContext: Context): CategoryRepository {
        return CategoryRepository(CategoryRemoteDataSource(CategoryService(NetworkManager())))
    }

    fun providePlaceRepository(context: Context): PlaceRepository {
        return PlaceRepository(
            PlaceLocalDataSource(
                provideAppDatabase(context).placeDao()
            ),
            PlaceRemoteDataSource(
                PlaceService(
                    NetworkManager()
                )
            )
        )
    }

    fun provideUserRepository(context: Context): UserRepository {
        return UserRepository(
            UserLocalDataSource(
                provideDefaultSharedPref(context)
            )
        )
    }

    private fun provideDefaultSharedPref(context: Context): SharedPreferences {
        return context.getSharedPreferences("user.data", Context.MODE_PRIVATE)
    }
}