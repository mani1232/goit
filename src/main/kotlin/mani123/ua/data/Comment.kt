package mani123.ua.data

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val postId: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val body: String = ""
)
