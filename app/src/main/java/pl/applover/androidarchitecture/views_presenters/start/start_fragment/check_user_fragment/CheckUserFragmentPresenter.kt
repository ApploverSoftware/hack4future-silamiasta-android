package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class CheckUserFragmentPresenter @Inject constructor()
    : Presenter<CheckUserFragmentContract.View>(), CheckUserFragmentContract.Presenter {

    override fun onViewAttached(view: CheckUserFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}