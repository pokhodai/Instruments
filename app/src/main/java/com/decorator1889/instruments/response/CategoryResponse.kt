package com.decorator1889.instruments.response

class CategoryResponse(
    val result: String?,
    val error: String?,
    val category: List<Category>?
) {
    data class Category(
        val id: Long?,
        val viewType: Int?,
        val name: String?,
        val picture: String?,
        val favorite: Boolean?,
        val description: String?
    )
}