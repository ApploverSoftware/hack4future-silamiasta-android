package pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import pl.applover.androidarchitecture.R
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_second.*
import pl.applover.androidarchitecture.util.extensions.showToast
import pl.applover.androidarchitecture.views_presenters.start.StartActivity
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification.CodeVerificationFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment
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

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialSetup()
    }

    fun initialSetup() {
        mCallbackManager = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                registeredSuccessfully()
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                showToast("Numer telefonu jest niepoprawny!")
            }

            override fun onCodeSent(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
                proceedToCodeCheck(verificationId, token)
            }

        }

        phone_btn_send.setOnClickListener {
            if (validatePassword())
                verifyPhoneNumber()
            else
                showToast("Hasła różnią się od siebie!")
        }
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    fun verifyPhoneNumber() {
        if (!validateName())
            showToast("Imię i nazwisko muszą mieć minimum 2 litery")
        else if (!phone_input_number.text.isNullOrEmpty())
            phoneAuthProvider.verifyPhoneNumber(phone_input_number.text.toString(), 60, TimeUnit.SECONDS, activity, mCallbackManager!!)
        else
            showToast("Numer telefonu jest niepoprawny!")
    }

    fun validatePassword(): Boolean {
        return (first_password.text.toString().isNotEmpty() && first_password.text.toString() == second_password.text.toString())
    }

    fun validateName(): Boolean{
        return (first_name.text.toString().length > 2 && last_name.text.toString().length > 2)
    }

    fun registeredSuccessfully() {
        (activity as StartActivity).mShowFragment(LoginFragment.newInstance(), "Login")
    }

    fun proceedToCodeCheck(verificationId: String?, token: PhoneAuthProvider.ForceResendingToken?) {
        val bundle = Bundle()
        bundle.putString(getString(R.string.verificationCode), verificationId)
        bundle.putString(getString(R.string.first_name), first_name.text.toString())
        bundle.putString(getString(R.string.second_name), last_name.text.toString())
        bundle.putString(getString(R.string.password), first_password.text.toString())
        bundle.putParcelable(getString(R.string.verificationToken), token)
        (activity as StartActivity).mShowFragment(CodeVerificationFragment.newInstance(bundle), "Verification")
    }


    override fun getLayoutResId(): Int = R.layout.fragment_second
}