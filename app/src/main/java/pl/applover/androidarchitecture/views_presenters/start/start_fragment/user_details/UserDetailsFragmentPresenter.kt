package pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class UserDetailsFragmentPresenter @Inject constructor()
    : Presenter<UserDetailsFragmentContract.View>(), UserDetailsFragmentContract.Presenter {

    override fun onViewAttached(view: UserDetailsFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}