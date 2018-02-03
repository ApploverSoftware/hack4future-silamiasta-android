package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class MainFragment : MvpFragment<MainFragmentContract.Presenter, MainFragmentContract.View>(),
        MainFragmentContract.View {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile_phone_number.setBackgroundColor(Color.GREEN)
        profile_idcard.setBackgroundColor(Color.GREEN)
        initializeListeners()
    }

    fun initializeListeners(){
        profile_facebook.setOnClickListener { facebookAuthorization() }
        profile_linkedin.setOnClickListener { linkedinAuthorization() }
    }

    fun facebookAuthorization(){

    }

    fun linkedinAuthorization(){

    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_main
}