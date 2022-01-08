package com.decorator1889.instruments.models

import com.decorator1889.instruments.response.CategoryResponse

data class Category(
    val id: Long,
    val viewType: Int,
    val name: String,
    val picture: String,
    val favorite: Boolean,
    val description: String
)

fun List<CategoryResponse.Category>?.toCategory(): List<Category> {
    return this?.map { categoryList ->
        Category(
            id = categoryList.id ?: 0L,
            viewType = categoryList.viewType ?: 0,
            name = categoryList.name ?: "",
            picture = categoryList.picture ?: "",
            favorite = categoryList.favorite ?: false,
            description = categoryList.description ?: ""
        )
    } ?: listOf()
}

fun getFakeCategory(): List<Category> {
    return listOf(
        Category(
            id = -1L,
            1,
            "",
            "",
            false,
            ""
        ),
        Category(
            id = 0L,
            viewType = 2,
            name = "Лигатурная игла Купера",
            picture = "https://ua.medsolve.com.ua/upload/mod_shop_photos/v-01-0051.jpg",
            favorite = true,
            description = "Хирургический инструмент для проведения шовного материала под кровеносные сосуды"
        ),
        Category(
            id = 1L,
            viewType = 2,
            name = "Лигатурная игла Купера",
            picture = "https://ua.medsolve.com.ua/upload/mod_shop_photos/v-01-0051.jpg",
            favorite = true,
            description = "Хирургический инструмент для проведения шовного материала под кровеносные сосуды"
        ),
        Category(
            id = 2L,
            viewType = 2,
            name = "Лигатурная игла Купера",
            picture = "https://ua.medsolve.com.ua/upload/mod_shop_photos/v-01-0051.jpg",
            favorite = true,
            description = "Хирургический инструмент для проведения шовного материала под кровеносные сосуды"
        ),
        Category(
            id = 3L,
            viewType = 2,
            name = "Лигатурная игла Купера",
            picture = "https://ua.medsolve.com.ua/upload/mod_shop_photos/v-01-0051.jpg",
            favorite = true,
            description = "Хирургический инструмент для проведения шовного материала под кровеносные сосуды"
        ),
        Category(
            id = 4L,
            viewType = 2,
            name = "Лигатурная игла Купера",
            picture = "https://ua.medsolve.com.ua/upload/mod_shop_photos/v-01-0051.jpg",
            favorite = true,
            description = "Хирургический инструмент для проведения шовного материала под кровеносные сосуды"
        )
    )
}