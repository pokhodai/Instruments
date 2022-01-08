package com.decorator1889.instruments.models

import com.decorator1889.instruments.response.CatalogResponse

data class Catalog(
    val id: Long,
    val name: String,
    val type: Int,
    val numbers: Long,
    val lock: Boolean
)

fun List<CatalogResponse.Catalog>?.toCatalog(): List<Catalog> {
    return this?.map { catalogList ->
        Catalog(
            id = catalogList.id ?: 0L,
            name = catalogList.name ?: "",
            type = catalogList.type ?: 0,
            numbers = catalogList.numbers ?: 0L,
            lock = catalogList.lock ?: false
        )
    } ?: listOf()
}

fun getFakeCatalog(): List<Catalog>{
    return listOf(
        Catalog(
            id = 0L,
            name = "Общая хирургия",
            type = 1,
            numbers = 31,
            true
        ),
        Catalog(
            id = 1L,
            name = "Стоматология",
            type = 2,
            numbers = 22,
            true,
        ),
        Catalog(
            id = 2L,
            name = "Акушерство\n" +
                    "и гинекология",
            type = 3,
            numbers = 40,
            true
        ),
        Catalog(
            id = 3L,
            name = "Нейрохирургия",
            type = 4,
            numbers = 51,
            false
        ),
        Catalog(
            id = 4L,
            name = "Офтальмология",
            type = 5,
            numbers = 33,
            false
        ),
        Catalog(
            id = 5L,
            name = "Оториноларингология",
            type = 6,
            numbers = 50,
            false
        ),
    )
}