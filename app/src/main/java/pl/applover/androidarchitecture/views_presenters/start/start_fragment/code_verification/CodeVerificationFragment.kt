package pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import com.google.firebase.auth.PhoneAuthProvider
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_code_verification.*
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.data.example.internet.params.ParamsSingUp
import pl.applover.androidarchitecture.util.extensions.showToast

/**
 * Created by kroll on 02.02.18.
 */
class CodeVerificationFragment() : MvpFragment<CodeVerificationFragmentContract.Presenter, CodeVerificationFragmentContract.View>(),
        CodeVerificationFragmentContract.View {


    private lateinit var mListener: FragmentInteraction
    private var verificationCode: String? = null
    private var token: PhoneAuthProvider.ForceResendingToken? = null
    private var firstName: String? = null
    private var lastName: String? = null
    private var password: String? = null
    private var userName: String? = null
    private var phoneNumber: String? = null

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        verificationCode = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.verificationCode))
        token = bundle?.getParcelable(pl.applover.androidarchitecture.util.extensions.getString(R.string.verificationToken))
        firstName = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.first_name))
        lastName = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.second_name))
        password = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.password))
        userName = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.KEY_USER_NAME))
        phoneNumber = bundle?.getString(pl.applover.androidarchitecture.util.extensions.getString(R.string.KEY_PHONE_NUMBER))

    }

    override fun onResume() {
        super.onResume()
        if (verificationCode == null) {
            presenter?.register(ParamsSingUp(ParamsSingUp.ParamsBody(ParamsSingUp.User(password!!, password!!, userName!!, phoneNumber!!, firstName!!, lastName!!))))
        }
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
        if (verificationCode == phone_code_input.text.toString() || verificationCode == null)
            presenter?.register(ParamsSingUp(ParamsSingUp.ParamsBody(ParamsSingUp.User(password!!, password!!, userName!!, phoneNumber!!, firstName!!, lastName!!))))
        else
            showToast("Nieprawidłowy kod")
    }

    override fun onRegisterSuccess() {
        proceed()
    }

    fun proceed() {
        mListener.onVerified()
    }

    override fun onRegisterFailed() {
        showToast("Register failed, unknown reason, sorry!")
    }

    companion object {
        fun newInstance(): CodeVerificationFragment {
            return CodeVerificationFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_code_verification

    interface FragmentInteraction {
        fun onVerified()
    }
}