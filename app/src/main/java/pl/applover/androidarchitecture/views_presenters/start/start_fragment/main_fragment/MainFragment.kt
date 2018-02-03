package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.linkedin.platform.LISessionManager
import com.linkedin.platform.errors.LIAuthError
import com.linkedin.platform.listeners.AuthListener
import com.linkedin.platform.utils.Scope
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_main.*
import pl.applover.androidarchitecture.App

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class MainFragment : MvpFragment<MainFragmentContract.Presenter, MainFragmentContract.View>(),
        MainFragmentContract.View {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile_phone_number.setBackground(ContextCompat.getDrawable(App.instance, R.drawable.login_oval_button_green))
        profile_idcard.setBackground(ContextCompat.getDrawable(App.instance, R.drawable.login_oval_button_green))
        initializeListeners()
    }

    fun initializeListeners(){
        profile_facebook.setOnClickListener { facebookAuthorization() }
        profile_linkedin.setOnClickListener { linkedinAuthorization() }
    }

    fun facebookAuthorization(){

    }

    fun linkedinAuthorization(){
        LISessionManager.getInstance(context).init(activity, Scope.build(), object : AuthListener{
            override fun onAuthSuccess() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAuthError(error: LIAuthError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }, true)
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }



    override fun getLayoutResId(): Int = R.layout.fragment_main
}