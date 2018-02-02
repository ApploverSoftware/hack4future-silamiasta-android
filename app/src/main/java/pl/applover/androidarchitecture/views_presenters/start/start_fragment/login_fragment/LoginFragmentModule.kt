package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by Janusz Hain on 2018-02-02.
 */
@Module
class LoginFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: LoginFragmentPresenter)
            : PresenterLoader<LoginFragmentContract.Presenter> = PresenterLoader(context, presenter)
}