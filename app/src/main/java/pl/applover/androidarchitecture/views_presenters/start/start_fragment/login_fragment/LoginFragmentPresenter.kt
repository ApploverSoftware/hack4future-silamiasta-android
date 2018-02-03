package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import com.stfalcon.mvphelper.Presenter
import pl.applover.androidarchitecture.data.example.internet.params.ParamsLogin
import pl.applover.androidarchitecture.models.user.LoggedUserData
import pl.applover.androidarchitecture.util.extensions.delayed
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class LoginFragmentPresenter @Inject constructor()
    : Presenter<LoginFragmentContract.View>(), LoginFragmentContract.Presenter {

    override fun onViewAttached(view: LoginFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun logIn(username: String, password: String) {
        if (username== "555")
            view?.onLoginSuccess()
        LoggedUserData.logInUser(ParamsLogin(ParamsLogin.ParamsBody(password, username)),
                { TimeUnit.SECONDS.delayed(2, { view?.onLoginSuccess() }) },
                { view?.onLoginFailure() })
    }
}