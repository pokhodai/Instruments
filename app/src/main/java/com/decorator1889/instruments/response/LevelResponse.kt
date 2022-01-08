package com.decorator1889.instruments.response

data class LevelResponse(
    val result: String?,
    val error: String?,
    val levels: List<Level>?
) {
    data class Level(
        val id: Long?,
        val name: String?,
        val numbersQuestion: Int?,
        val type: String?
    )
}