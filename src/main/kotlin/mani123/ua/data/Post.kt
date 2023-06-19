package mani123.ua.data

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
)
