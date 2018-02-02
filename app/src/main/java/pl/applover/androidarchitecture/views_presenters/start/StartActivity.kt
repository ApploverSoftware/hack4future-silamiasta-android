package pl.applover.androidarchitecture.views_presenters.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpActivity
import pl.applover.androidarchitecture.util.extensions.goToActivity
import pl.applover.androidarchitecture.util.extensions.showFragment
import pl.applover.androidarchitecture.views_presenters.example.main.ExampleMainActivity

/**
 * Created by Janusz Hain on 2018-01-08.
 */
class StartActivity : MvpActivity<StartActivityContract.Presenter, StartActivityContract.View>(),
        StartActivityContract.View {

    override fun getLayoutResId(): Int = R.layout.activity_start

    @SuppressLint("MissingSuperCall")
    override fun onStart() {
        super.onStart()
        goToActivity(ExampleMainActivity::class.java)
    }

    fun mShowFragment(fragment: Fragment, tag : String){
        showFragment(fragment, R.id.main_frame_layout, true, 0, 0, tag)
    }

}
