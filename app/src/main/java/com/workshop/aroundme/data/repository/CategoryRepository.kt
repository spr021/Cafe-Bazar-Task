package com.workshop.aroundme.data.repository

import com.workshop.aroundme.data.model.ParentCategoryEntity
import com.workshop.aroundme.remote.datasource.CategoryRemoteDataSource
import kotlin.concurrent.thread

class CategoryRepository(private val categoryRemoteDataSource: CategoryRemoteDataSource) {

    fun getCategories(success: (List<ParentCategoryEntity>?) -> Unit) {
        thread {
            val categories = categoryRemoteDataSource.getCategories()
            success(categories)
        }
    }
}