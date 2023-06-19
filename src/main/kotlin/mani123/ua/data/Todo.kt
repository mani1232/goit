package mani123.ua.data

import kotlinx.serialization.Serializable

@Serializable
data class Todo (
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)

