package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import com.stfalcon.mvphelper.Presenter
import pl.applover.androidarchitecture.data.example.internet.params.ParamsGetUser
import pl.applover.androidarchitecture.interactors.sila_miasta.InteractorGetUser
import javax.inject.Inject

/**
 * Created by Janusz Hain on 2018-02-03.
 */
class CheckUserFragmentPresenter @Inject constructor()
    : Presenter<CheckUserFragmentContract.View>(), CheckUserFragmentContract.Presenter {

    private val interactorCheckUser = InteractorGetUser()

    override fun checkUser(userId: String) {
        interactorCheckUser.execute({responseCheckUser ->  view?.onCheckUserSuccess(responseCheckUser)}, { code: Int? -> view?.onCheckUserFailure()}, ParamsGetUser(userId))
    }

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