package pl.applover.androidarchitecture.models.user

import pl.applover.androidarchitecture.data.example.internet.params.ParamsLogin
import pl.applover.androidarchitecture.interactors.sila_miasta.InteractorLogIn

/**
 * Created by Janusz Hain on 2018-02-03.
 */
object LoggedUserData {
    var token: String? = null
    var device: String? = null
    var userName: String? = null

    var user: User? = null

    private val interactorLogIn = InteractorLogIn()

    fun logInUser(paramsLogin: ParamsLogin, success: () -> Unit, failure: () -> Unit) {
        interactorLogIn.execute({ responseLogIn ->
            token = responseLogIn.authToken.token
            device = responseLogIn.authToken.device
            userName = responseLogIn.user.username
            user = User(responseLogIn.user)
            success()
        }, { code: Int? -> failure() }, paramsLogin)
    }

    fun unsubscribeLogIn() {
        interactorLogIn.unsubscribe()
    }


}