package pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by kroll on 02.02.18.
 */
@Module
class SecondFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: SecondFragmentPresenter)
            : PresenterLoader<SecondFragmentContract.Presenter> = PresenterLoader(context, presenter)
}