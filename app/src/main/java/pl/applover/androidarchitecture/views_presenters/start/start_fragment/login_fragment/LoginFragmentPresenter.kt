package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import com.stfalcon.mvphelper.Presenter
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

    override fun logIn(number: String, pin: String) {

    }
}