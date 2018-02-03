package pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details

import com.stfalcon.mvphelper.MvpFragment
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class UserDetailsFragment : MvpFragment<UserDetailsFragmentContract.Presenter, UserDetailsFragmentContract.View>(),
        UserDetailsFragmentContract.View {

    private val userDetails by lazy {
        arguments.getParcelable<ResponseCheckUser>(getString(R.string.KEY_CHECK_USER))
    }

    companion object {
        fun newInstance(): UserDetailsFragment {
            return UserDetailsFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_user_details

    override fun onResume() {
        super.onResume()

    }

    fun showUserDetails(){

    }
}