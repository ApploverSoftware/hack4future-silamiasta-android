package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class MainFragmentPresenter @Inject constructor()
    : Presenter<MainFragmentContract.View>(), MainFragmentContract.Presenter {

    override fun onViewAttached(view: MainFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}