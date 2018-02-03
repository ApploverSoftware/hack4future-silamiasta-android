package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class CheckUserFragment : MvpFragment<CheckUserFragmentContract.Presenter, CheckUserFragmentContract.View>(),
        CheckUserFragmentContract.View {

    companion object {
        fun newInstance(): CheckUserFragment {
            return CheckUserFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_check_user
}