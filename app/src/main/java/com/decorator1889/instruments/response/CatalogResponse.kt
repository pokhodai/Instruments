package com.decorator1889.instruments.response

data class CatalogResponse(
    val result: String?,
    val error: String?,
    val catalog: List<Catalog>?
) {
    data class Catalog(
        val id: Long?,
        val name: String?,
        val type: Int?,
        val numbers: Long?,
        val lock: Boolean?
    )
}