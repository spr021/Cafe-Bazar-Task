package com.workshop.aroundme.remote.model.response

data class CategoryResponseDto(
    val meta: Meta?,
    val response: Map<String, List<CategoryDto>>?
)

data class CategoryDto(
    val icon: String?,
    val id: Int?,
    val name: String?,
    val parent: Int?
)