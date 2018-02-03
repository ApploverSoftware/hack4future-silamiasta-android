package pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification

import com.stfalcon.mvphelper.IPresenter
import pl.applover.androidarchitecture.data.example.internet.params.ParamsSingUp

/**
 * Created by kroll on 02.02.18.
 */
interface CodeVerificationFragmentContract {

    interface View {
        fun onRegisterSuccess()
        fun onRegisterFailed()
    }

    interface Presenter : IPresenter<View> {
        fun register(paramsSignUp: ParamsSingUp)
    }
}