package pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details

import android.graphics.Color
import android.support.v4.content.ContextCompat
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_user_details.*
import org.jetbrains.anko.textColor
import pl.applover.androidarchitecture.App
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class UserDetailsFragment : MvpFragment<UserDetailsFragmentContract.Presenter, UserDetailsFragmentContract.View>(),
        UserDetailsFragmentContract.View {

    companion object {
        fun newInstance(): UserDetailsFragment {
            return UserDetailsFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_user_details

    override fun onResume() {
        super.onResume()
        showUserDetails()
    }

    fun showUserDetails() {
        val checkUser = arguments.getParcelable<ResponseCheckUser>(getString(R.string.KEY_CHECK_USER))
        profile_id.setText(checkUser.user.username)
        profile_confirmations.setText("APPROVALS: " + checkUser.user.balances.approval)
        profile_complains.setText("COMPLAINS: " + checkUser.user.balances.disapproval)
        profile_phone_number.setBackground(ContextCompat.getDrawable(App.instance, R.drawable.login_oval_button_green))
        profile_phone_number.setText("PHONE NUMBER VERIFIED")
        profile_phone_number.setTextColor(Color.parseColor("#ffffff"))
        if (checkUser.user.balances.facebook) {
            profile_facebook.setBackground(ContextCompat.getDrawable(App.instance, R.drawable.login_oval_button_green))
            profile_facebook.text = "FACEBOOK VERIFIED"
            profile_facebook.setTextColor(Color.parseColor("#ffffff"))
        }

        val votes = checkUser.user.balances.approval + checkUser.user.balances.disapproval

        profile_transactions.text = "" + votes + " votes"
    }
}