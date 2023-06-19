package mani123.ua.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: Address,
    var phone: String,
    var website: String,
    var company: Company
) {
    constructor() : this(
        11,
        "not_set",
        "not_set",
        "not_set",
        Address(),
        "not_set",
        "not_set",
        Company()
    )
}

@Serializable
data class Address(
    var street: String,
    var suite: String,
    var city: String,
    var zipcode: String,
    var geo: Geo
) {
    constructor() : this(
        "not_set", "not_set", "not_set", "not_set", Geo()
    )
}

@Serializable
data class Geo(
    var lat: String,
    var lng: String
) {
    constructor(): this(
        "not_set", "not_set"
    )
}

@Serializable
data class Company(
    var name: String,
    var catchPhrase: String,
    var bs: String
) {
    constructor(): this(
        "not_set", "not_set", "not_set"
    )
}
