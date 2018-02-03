package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import android.content.Context
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_check_user.*
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser
import pl.applover.androidarchitecture.util.extensions.showToast

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class CheckUserFragment : MvpFragment<CheckUserFragmentContract.Presenter, CheckUserFragmentContract.View>(),
        CheckUserFragmentContract.View {

    private lateinit var mListener: FragmentInteraction

    companion object {
        fun newInstance(): CheckUserFragment {
            return CheckUserFragment()
        }
    }

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
        buttonCheckUser.setOnClickListener {
            presenter?.checkUser(editTextUser.text.toString())
        }
    }

    override fun onCheckUserSuccess(responseCheckUser: ResponseCheckUser) {
        mListener.onUserRetrieved(responseCheckUser)
    }

    override fun onCheckUserFailure() {
        showToast("Error getting user")
    }

    override fun getLayoutResId(): Int = R.layout.fragment_check_user

    interface FragmentInteraction {
        fun onUserRetrieved(responseCheckUser: ResponseCheckUser)
    }
}