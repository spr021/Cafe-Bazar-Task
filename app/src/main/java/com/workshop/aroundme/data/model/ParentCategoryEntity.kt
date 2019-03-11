package com.workshop.aroundme.data.model

data class ParentCategoryEntity(
    val name: String?,
    val children: List<CategoryEntity>?
)

data class CategoryEntity(
    val icon: String?,
    val id: Int?,
    val name: String?
)