package pl.applover.androidarchitecture.views_presenters.start

import android.annotation.SuppressLint
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment

/**
 * Created by Janusz Hain on 2018-01-08.
 */
class StartActivity : MvpActivity<StartActivityContract.Presenter, StartActivityContract.View>(),
        StartActivityContract.View, LoginFragment.FragmentInteraction {

    override fun getLayoutResId(): Int = R.layout.activity_start

    @SuppressLint("MissingSuperCall")
    override fun onStart() {
        super.onStart()
    }

    override fun onLoggedIn() {
        //todo
    }

    override fun onRegisterClicked() {
        //todo
    }
}
