package pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by Janusz Hain on 2018-02-03.
 */
@Module
class UserDetailsFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: UserDetailsFragmentPresenter)
            : PresenterLoader<UserDetailsFragmentContract.Presenter> = PresenterLoader(context, presenter)
}