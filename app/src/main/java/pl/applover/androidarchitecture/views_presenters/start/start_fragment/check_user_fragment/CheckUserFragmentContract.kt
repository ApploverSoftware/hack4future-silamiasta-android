package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import com.stfalcon.mvphelper.IPresenter
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser

/**
 * Created by Janusz Hain on 2018-02-03.
 */
interface CheckUserFragmentContract {

    interface View {
        fun onCheckUserSuccess(responseCheckUser: ResponseCheckUser)
        fun onCheckUserFailure()
    }

    interface Presenter : IPresenter<View> {
        fun checkUser(userId: String)
    }
}