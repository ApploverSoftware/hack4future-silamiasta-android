package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class MainFragment : MvpFragment<MainFragmentContract.Presenter, MainFragmentContract.View>(),
        MainFragmentContract.View {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_main
}