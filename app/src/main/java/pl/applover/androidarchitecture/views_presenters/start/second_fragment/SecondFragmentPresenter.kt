package pl.applover.androidarchitecture.views_presenters.start.second_fragment

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by kroll on 02.02.18.
 */
class SecondFragmentPresenter @Inject constructor()
    : Presenter<SecondFragmentContract.View>(), SecondFragmentContract.Presenter {

    override fun onViewAttached(view: SecondFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}