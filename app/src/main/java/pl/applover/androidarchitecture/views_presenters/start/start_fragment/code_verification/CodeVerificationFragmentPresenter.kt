package pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by kroll on 02.02.18.
 */
class CodeVerificationFragmentPresenter @Inject constructor()
    : Presenter<CodeVerificationFragmentContract.View>(), CodeVerificationFragmentContract.Presenter {

    override fun onViewAttached(view: CodeVerificationFragmentContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}