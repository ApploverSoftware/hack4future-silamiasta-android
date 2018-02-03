package pl.applover.androidarchitecture.models.user

import pl.applover.androidarchitecture.data.example.internet.response.ResponseLogIn

/**
 * Created by Janusz Hain on 2018-02-03.
 */
data class User(val responseUser: ResponseLogIn.User) {
    val id: Int = responseUser.id
    val phoneNumber: String = responseUser.phoneNumber
    val passwordDigest: String = responseUser.passwordDigest
    val chainKey: String = responseUser.chainKey
    val username: String = responseUser.username
    val firstName: String = responseUser.firstName
    val lastName: String = responseUser.lastName
    val facebookId: String? = responseUser.facebookId
    val createdAt: String = responseUser.createdAt
    val updatedAt: String = responseUser.updatedAt
}