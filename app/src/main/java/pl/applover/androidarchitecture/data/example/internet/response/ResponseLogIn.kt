package pl.applover.androidarchitecture.data.example.internet.response

import com.squareup.moshi.Json


/**
 * Created by Janusz Hain on 2018-01-12.
 */
data class ResponseLogIn(
        @Json(name = "auth_token") val authToken: AuthToken,
        @Json(name = "user") val user: User
) {
    data class User(
            @Json(name = "id") val id: Int,
            @Json(name = "phone_number") val phoneNumber: String,
            @Json(name = "password_digest") val passwordDigest: String,
            @Json(name = "chain_key") val chainKey: String,
            @Json(name = "username") val username: String,
            @Json(name = "first_name") val firstName: String,
            @Json(name = "last_name") val lastName: String,
            @Json(name = "facebook_id") val facebookId: String?,
            @Json(name = "created_at") val createdAt: String,
            @Json(name = "updated_at") val updatedAt: String
    )

    data class AuthToken(
            @Json(name = "token") val token: String,
            @Json(name = "device") val device: String
    )
}


