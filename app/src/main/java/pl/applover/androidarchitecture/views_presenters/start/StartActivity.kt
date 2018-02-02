package pl.applover.androidarchitecture.views_presenters.start

import android.annotation.SuppressLint
<<<<<<< HEAD
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.util.extensions.goToActivity
import pl.applover.androidarchitecture.util.extensions.showFragment
import pl.applover.androidarchitecture.views_presenters.example.main.ExampleMainActivity
=======
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment
>>>>>>> origin/feeature-login-register-screen

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

    fun mShowFragment(fragment: Fragment, tag : String){
        showFragment(fragment, R.id.main_frame_layout, true, 0, 0, tag)
    }

}
