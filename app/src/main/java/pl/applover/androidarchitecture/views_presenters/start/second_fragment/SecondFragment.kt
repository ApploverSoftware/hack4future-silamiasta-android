package pl.applover.androidarchitecture.views_presenters.start.second_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_second.*
import pl.applover.androidarchitecture.util.extensions.showToast
import pl.applover.androidarchitecture.views_presenters.start.StartActivity
import pl.applover.androidarchitecture.views_presenters.start.codeVerification.CodeVerificationFragment
import java.util.concurrent.TimeUnit

/**
 * Created by kroll on 02.02.18.
 */
class SecondFragment : MvpFragment<SecondFragmentContract.Presenter, SecondFragmentContract.View>(),
        SecondFragmentContract.View {
    val phoneAuthProvider = PhoneAuthProvider.getInstance()
    var mCallbackManager: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialSetup()
    }

    fun initialSetup() {
        phone_btn_send.setOnClickListener { verifyPhoneNumber() }

        mCallbackManager = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                registeredSuccessfully()
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                showToast("Niepoprawny numer telefonu")
            }

            override fun onCodeSent(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
                proceedToCodeCheck(verificationId, token)
            }

        }
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    fun verifyPhoneNumber() {
        if (!phone_input_number.text.isNullOrEmpty())
            phoneAuthProvider.verifyPhoneNumber(phone_input_number.text.toString(), 60, TimeUnit.SECONDS, activity, mCallbackManager!!)
        else
            showToast("Numer telefonu jest niepoprawny")
    }

    fun registeredSuccessfully() {

    }

    fun proceedToCodeCheck(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
        val bundle = Bundle()
        bundle.putString(getString(R.string.verificationCode), verificationId)
        bundle.putParcelable(getString(R.string.verificationToken), token)
        (activity as StartActivity).mShowFragment(CodeVerificationFragment.newInstance(bundle), "Verification")
    }


    override fun getLayoutResId(): Int = R.layout.fragment_second
}