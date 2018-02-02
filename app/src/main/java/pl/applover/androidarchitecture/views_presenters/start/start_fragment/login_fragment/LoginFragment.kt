package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class LoginFragment : MvpFragment<LoginFragmentContract.Presenter, LoginFragmentContract.View>(),
        LoginFragmentContract.View {

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_login
}