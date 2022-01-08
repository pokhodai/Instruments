package com.decorator1889.instruments.models

import com.decorator1889.instruments.response.CatalogResponse
import com.decorator1889.instruments.response.LevelResponse

data class Level(
    val id: Long,
    val name: String,
    val numbersQuestion: Int,
    val type: String
)

fun List<LevelResponse.Level>?.toLevels(): List<Level> {
    return this?.map { levelsList ->
        Level(
            id = levelsList.id ?: 0L,
            name = levelsList.name ?: "",
            numbersQuestion = levelsList.numbersQuestion ?: 0,
            type = levelsList.type ?: ""
        )
    } ?: listOf()
}

fun getFakeLevels(): List<Level> {
    return listOf(
        Level(
            id = 0L,
            name = "Легкий уровень",
            numbersQuestion = 30,
            type = "easy"
        ),
        Level(
            id = 1L,
            name = "Средний уровень",
            numbersQuestion = 25,
            type = "middle"
        ),
        Level(
            id = 2L,
            name = "Сложный уровень",
            numbersQuestion = 40,
            type = "hard"
        )
    )
}