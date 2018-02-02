package pl.applover.androidarchitecture.views_presenters.start

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.util.extensions.showFragment
import pl.applover.androidarchitecture.views_presenters.start.second_fragment.SecondFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.StartFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment


/**
 * Created by Janusz Hain on 2018-01-08.
 */
class StartActivity : MvpActivity<StartActivityContract.Presenter, StartActivityContract.View>(),
        StartActivityContract.View, LoginFragment.FragmentInteraction, StartFragment.FragmentInteraction {

    override fun getLayoutResId(): Int = R.layout.activity_start

    @SuppressLint("MissingSuperCall")
    override fun onStart() {
        super.onStart()
        showFragment(StartFragment.newInstance(), R.id.main_frame_layout, false)

    }

    override fun onSplashEnded() {
        showFragment(LoginFragment.newInstance(), R.id.main_frame_layout)
    }

    override fun onLoggedIn() {
        //todo
    }

    override fun onRegisterClicked() {
        showFragment(SecondFragment.newInstance(), R.id.main_frame_layout)
    }

    fun mShowFragment(fragment: Fragment, tag: String) {
        showFragment(fragment, R.id.main_frame_layout, true, 0, 0, tag)
    }

}
