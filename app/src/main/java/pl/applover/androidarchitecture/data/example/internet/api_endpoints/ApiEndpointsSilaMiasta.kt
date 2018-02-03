package pl.applover.androidarchitecture.data.example.internet.api_endpoints

import io.reactivex.Single
import pl.applover.androidarchitecture.data.example.internet.params.ParamsCreateFacebookAsset
import pl.applover.androidarchitecture.data.example.internet.params.ParamsLogin
import pl.applover.androidarchitecture.data.example.internet.params.ParamsSingUp
import pl.applover.androidarchitecture.data.example.internet.response.ResponseLogIn
import pl.applover.androidarchitecture.models.user.LoggedUserData
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Janusz Hain on 2018-02-02.
 */
interface ApiEndpointsSilaMiasta {

    @POST("/api/v1/auth_token")
    fun logIn(
            @Body jsonBody: ParamsLogin.ParamsBody,
            @Header("Content-Type") contentType: String = "application/json",
            @Header("Accept") accept: String = "application/json"
    ): Single<Response<ResponseLogIn>>

    @POST("/api/v1/users")
    fun singUp(
            @Body jsonBody: ParamsSingUp.ParamsBody,
            @Header("Content-Type") contentType: String = "application/json",
            @Header("Accept") accept: String = "application/json"

    ): Single<Response<Void>>


    @GET("/api/v1/users/{id}")
    fun getUser(
            @Path("id") id: Int,
            @Header("Content-Type") contentType: String = "application/json",
            @Header("Accept") accept: String = "application/json"
    ): Single<Response<Void>>

    @GET("/api/v1/assets")
    fun createFacebookAsset(
            @Body jsonBody: ParamsCreateFacebookAsset.ParamsBody,
            @Header("Authorization") auth: String = "Token token=" + LoggedUserData.token!!,
            @Header("Device") device: String = LoggedUserData.device!!,
            @Header("Username") username: String = LoggedUserData.userName!!,
            @Header("Content-Type") contentType: String = "application/json",
            @Header("Accept") accept: String = "application/json"
    ): Single<Response<Void>>
}