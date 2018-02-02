package pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by kroll on 02.02.18.
 */
@Module
class CodeVerificationFragmentModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: CodeVerificationFragmentPresenter)
            : PresenterLoader<CodeVerificationFragmentContract.Presenter> = PresenterLoader(context, presenter)
}