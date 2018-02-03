package pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification

import android.content.Context
import android.os.Bundle
import com.google.firebase.auth.PhoneAuthProvider
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_code_verification.*
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.util.extensions.getString
import pl.applover.androidarchitecture.util.extensions.showToast

/**
 * Created by kroll on 02.02.18.
 */
class CodeVerificationFragment() : MvpFragment<CodeVerificationFragmentContract.Presenter, CodeVerificationFragmentContract.View>(),
        CodeVerificationFragmentContract.View {

    private lateinit var mListener: FragmentInteraction


    override fun onResume() {
        super.onResume()
        phone_btn_verify.setOnClickListener {
            validateCode()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentInteraction) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ${FragmentInteraction::class.java.name}")
        }
    }

    fun validateCode() {
        if (verificationCode == phone_code_input.text.toString())
            proceed()
        else
            showToast("Nieprawidłowy kod")
    }

    fun proceed() {
        mListener.onVerified()
    }

    companion object {
        var verificationCode: String? = null
        var token: PhoneAuthProvider.ForceResendingToken? = null
        var firstName: String? = null
        var lastName: String? = null
        var password: String? = null

        fun newInstance(bundle: Bundle): CodeVerificationFragment {
            verificationCode = bundle.getString(getString(R.string.verificationCode))
            token = bundle.getParcelable(getString(R.string.verificationToken))
            firstName = bundle.getString(getString(R.string.first_name))
            lastName = bundle.getString(getString(R.string.second_name))
            password = bundle.getString(getString(R.string.password))
            return CodeVerificationFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_code_verification

    interface FragmentInteraction {
        fun onVerified()
    }
}