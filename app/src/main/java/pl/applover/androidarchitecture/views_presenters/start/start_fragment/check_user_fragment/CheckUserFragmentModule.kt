package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by Janusz Hain on 2018-02-03.
 */
@Module
class CheckUserFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: CheckUserFragmentPresenter)
            : PresenterLoader<CheckUserFragmentContract.Presenter> = PresenterLoader(context, presenter)
}