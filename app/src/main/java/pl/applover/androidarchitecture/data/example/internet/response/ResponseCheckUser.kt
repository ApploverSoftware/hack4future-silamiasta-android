package pl.applover.androidarchitecture.data.example.internet.response

import com.squareup.moshi.Json


/**
 * Created by Janusz Hain on 2018-02-03.
 */

data class ResponseCheckUser(
        @Json(name = "user") val user: User
) {

    data class User(
            @Json(name = "username") val username: String,
            @Json(name = "phone_number") val phoneNumber: String,
            @Json(name = "first_name") val firstName: String,
            @Json(name = "last_name") val lastName: String,
            @Json(name = "balances") val balances: Balances
    )

    data class Balances(
            @Json(name = "facebook") val facebook: Boolean,
            @Json(name = "instagram") val instagram: Boolean,
            @Json(name = "email") val email: Boolean,
            @Json(name = "phone_number") val phoneNumber: Boolean,
            @Json(name = "approval") val approval: Int,
            @Json(name = "disapproval") val disapproval: Int
    )
}