package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.stfalcon.mvphelper.MvpFragment
import kotlinx.android.synthetic.main.fragment_login.*
import pl.applover.androidarchitecture.R
import pl.applover.androidarchitecture.util.extensions.showToast
import pl.applover.androidarchitecture.util.ui.start
import pl.applover.androidarchitecture.util.ui.stop

/**
 * Created by Janusz Hain on 2018-02-02.
 */
class LoginFragment : MvpFragment<LoginFragmentContract.Presenter, LoginFragmentContract.View>(),
        LoginFragmentContract.View {

    private lateinit var mListener: FragmentInteraction

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_login

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentInteraction) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ${FragmentInteraction::class.java.name}")
        }
    }


    override fun onResume() {
        super.onResume()
        setListeners()
    }

    private fun setListeners() {
        buttonLogIn.setOnClickListener {
            checkInputsAndTryToLogin()
        }

        buttonRegister.setOnClickListener {
            mListener.onRegisterClicked()
        }

        buttonCheckUser.setOnClickListener {
            mListener.onCheckUserClicked()
        }
    }

    private fun checkInputsAndTryToLogin() {
        if (editTextNumber.text.toString().isEmpty()) {
            showToast("Pass number")
            return
        }

        if (editTextPassword.text.toString().isEmpty()) {
            showToast("Pass password")
            return
        }

        buttonLogIn.start()
        buttonLogIn.isClickable = false
        presenter?.logIn(editTextNumber.text.toString(), editTextPassword.text.toString())
    }

    override fun onLoginSuccess() {
        buttonLogIn.stop(true)
        buttonLogIn.isClickable = true
        mListener.onLoggedIn()
        if (view != null) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
        }
    }

    override fun onLoginFailure() {
        buttonLogIn.errorText = "Błąd logowania"
        buttonLogIn.isClickable = true
        buttonLogIn.stop(false, 2000)
    }

    interface FragmentInteraction {
        fun onLoggedIn()
        fun onRegisterClicked()
        fun onCheckUserClicked()
    }
}