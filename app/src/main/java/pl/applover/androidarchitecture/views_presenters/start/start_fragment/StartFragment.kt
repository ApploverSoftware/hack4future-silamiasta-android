package pl.applover.androidarchitecture.views_presenters.start.start_fragment

import android.content.Context
import com.stfalcon.mvphelper.MvpFragment
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.util.extensions.delayed
import java.util.concurrent.TimeUnit

/**
 * Created by Janusz Hain on 2018-01-08.
 */
class StartFragment : MvpFragment<StartFragmentContract.Presenter, StartFragmentContract.View>(),
        StartFragmentContract.View {

    private lateinit var mListener: FragmentInteraction

    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_start

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentInteraction) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ${FragmentInteraction::class.java.name}")
        }
    }

    override fun onResume() {
        super.onResume()
        TimeUnit.SECONDS.delayed(2, {
            mListener.onSplashEnded()
        })
    }

    interface FragmentInteraction {
        fun onSplashEnded()
    }
}