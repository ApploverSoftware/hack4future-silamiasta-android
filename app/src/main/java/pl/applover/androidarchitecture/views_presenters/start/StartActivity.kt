package pl.applover.androidarchitecture.views_presenters.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser
import pl.applover.androidarchitecture.util.extensions.showFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.StartFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment.CheckUserFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification.CodeVerificationFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment.MainFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment.SecondFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details.UserDetailsFragment


/**
 * Created by Janusz Hain on 2018-01-08.
 */
class StartActivity : MvpActivity<StartActivityContract.Presenter, StartActivityContract.View>(),
        StartActivityContract.View, LoginFragment.FragmentInteraction, StartFragment.FragmentInteraction, CodeVerificationFragment.FragmentInteraction,
        CheckUserFragment.FragmentInteraction {

    override fun getLayoutResId(): Int = R.layout.activity_start

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragment(StartFragment.newInstance(), R.id.main_frame_layout, false)
    }

    override fun onSplashEnded() {
        if(!isFinishing || !isDestroyed)
        showFragment(LoginFragment.newInstance(), R.id.main_frame_layout)
    }

    override fun onLoggedIn() {
        showFragment(MainFragment.newInstance(), R.id.main_frame_layout)
    }

    override fun onRegisterClicked() {
        showFragment(SecondFragment.newInstance(), R.id.main_frame_layout)
    }

    fun mShowFragment(fragment: Fragment, tag: String) {
        showFragment(fragment, R.id.main_frame_layout, true, 0, 0, tag)
    }

    override fun onVerified() {
        showFragment(LoginFragment.newInstance(), R.id.main_frame_layout, true)
    }

    override fun onCheckUserClicked() {
        showFragment(CheckUserFragment.newInstance(), R.id.main_frame_layout, true)
    }

    override fun onUserRetrieved(responseCheckUser: ResponseCheckUser) {
        val bundle = Bundle()
        bundle.putParcelable(getString(R.string.KEY_CHECK_USER), responseCheckUser)
        val fragment = UserDetailsFragment.newInstance()
        fragment.arguments = bundle
        showFragment(fragment, R.id.main_frame_layout, true)
    }

}
