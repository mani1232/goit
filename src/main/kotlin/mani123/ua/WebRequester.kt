package mani123.ua

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import mani123.ua.data.Comment
import mani123.ua.data.Post
import mani123.ua.data.User
import mani123.ua.data.Todo
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class WebRequester(
    private val link: String
) {

    private var client: HttpClient = HttpClient.newBuilder().build()
    private lateinit var request: HttpRequest

    fun sendRequest(): HttpResponse<String>? {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get()
    }

    fun postUserRequest(user: User, endLink: String): WebRequester {
        request = HttpRequest.newBuilder()
            .uri(URI.create("$link/$endLink"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(Json.encodeToString(user)))
            .build()
        return this
    }

    fun getRequest(endLink: String, requestField: String?, requestData: String?): WebRequester {
        val uri: URI = if (requestField == null && requestData == null) URI.create("$link/$endLink") else URI.create("$link/$endLink?$requestField=$requestData")
        request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-Type", "application/json")
            .GET()
            .build()
        return this
    }

    companion object {
        fun saveToFiles (data: HashMap<File, ArrayList<Comment>>) {
            data.forEach {
                val writer = BufferedWriter(FileWriter(it.key))
                writer.write(Json.encodeToString(it.value))
                writer.close()
            }
        }
    }

    fun sendRequestAndReturnUserList(): List<User> {
        return sendRequestAndReturnList<User>()
    }

    fun sendRequestAndReturnPostList(): List<Post> {
        return sendRequestAndReturnList<Post>()
    }

    fun sendRequestAndReturnCommentList(): List<Comment> {
        return sendRequestAndReturnList<Comment>()
    }

    fun sendRequestAndReturnTodoList(): List<Todo> {
        return sendRequestAndReturnList<Todo>()
    }

    private inline fun <reified T> sendRequestAndReturnList(): List<T> {
        return sendRequest().let { Json.decodeFromString<List<T>>(it!!.body()) }
    }

    fun deleteUserRequest(endLink: String, userId: String): WebRequester {
        request = HttpRequest.newBuilder()
            .uri(URI.create("$link/$endLink/$userId"))
            .header("Content-Type", "application/json")
            .DELETE()
            .build()
        return this
    }

    fun putUserRequest(user: User, endLink: String): WebRequester {
        request = HttpRequest.newBuilder()
            .uri(URI.create("$link/$endLink/${user.id}"))
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(Json.encodeToString(user)))
            .build()
        return this
    }

}