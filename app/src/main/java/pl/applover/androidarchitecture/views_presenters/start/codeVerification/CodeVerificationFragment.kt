package pl.applover.androidarchitecture.views_presenters.start.codeVerification

import android.os.Bundle
import com.google.firebase.auth.PhoneAuthProvider
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_code_verification.*
import pl.applover.androidarchitecture.util.extensions.getString
import pl.applover.androidarchitecture.util.extensions.showToast

/**
 * Created by kroll on 02.02.18.
 */
class CodeVerificationFragment() : MvpFragment<CodeVerificationFragmentContract.Presenter, CodeVerificationFragmentContract.View>(),
        CodeVerificationFragmentContract.View {



    fun validateCode(){
        if (verificationCode == phone_code_input.text.toString())
            proceed()
        else
            showToast("Nieprawidłowy kod")
    }

    fun proceed(){

    }

    companion object {
        var verificationCode: String? = null
        var token: PhoneAuthProvider.ForceResendingToken? = null

        fun newInstance(bundle: Bundle): CodeVerificationFragment {
           verificationCode = bundle.getString(getString(R.string.verificationCode))
            token = bundle.getParcelable(getString(R.string.verificationToken))
            return CodeVerificationFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_code_verification
}