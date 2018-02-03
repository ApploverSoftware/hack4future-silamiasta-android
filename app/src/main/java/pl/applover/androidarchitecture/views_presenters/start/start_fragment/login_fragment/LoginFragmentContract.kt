package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import com.stfalcon.mvphelper.IPresenter

/**
 * Created by Janusz Hain on 2018-02-02.
 */
interface LoginFragmentContract {

    interface View {
        fun onLoginSuccess()
        fun onLoginFailure()
    }

    interface Presenter : IPresenter<View> {
        fun logIn(username: String, password: String)
    }
}