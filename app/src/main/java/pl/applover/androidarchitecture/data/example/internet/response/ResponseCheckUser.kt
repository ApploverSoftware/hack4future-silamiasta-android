package pl.applover.androidarchitecture.data.example.internet.response

import android.annotation.SuppressLint
import com.squareup.moshi.Json
import io.mironov.smuggler.AutoParcelable


/**
 * Created by Janusz Hain on 2018-02-03.
 */

@SuppressLint("ParcelCreator")
data class ResponseCheckUser(
        @Json(name = "user") val user: ResponseCheckUser.User
) : AutoParcelable {

    @SuppressLint("ParcelCreator")
    data class User(
            @Json(name = "username") val username: String,
            @Json(name = "phone_number") val phoneNumber: String,
            @Json(name = "first_name") val firstName: String,
            @Json(name = "last_name") val lastName: String,
            @Json(name = "balances") val balances: ResponseCheckUser.Balances
    ) : AutoParcelable

    @SuppressLint("ParcelCreator")
    data class Balances(
            @Json(name = "facebook") val facebook: Boolean,
            @Json(name = "instagram") val instagram: Boolean,
            @Json(name = "phone_number") val phoneNumber: Boolean,
            @Json(name = "email") val email: Boolean,
            @Json(name = "linked_in") val linkedIn: Boolean,
            @Json(name = "approval") val approval: Int,
            @Json(name = "disapproval") val disapproval: Int
    ) : AutoParcelable

}