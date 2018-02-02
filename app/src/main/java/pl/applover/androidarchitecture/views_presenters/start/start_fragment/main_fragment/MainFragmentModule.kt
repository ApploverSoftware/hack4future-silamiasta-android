package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by Janusz Hain on 2018-02-02.
 */
@Module
class MainFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: MainFragmentPresenter)
            : PresenterLoader<MainFragmentContract.Presenter> = PresenterLoader(context, presenter)
}