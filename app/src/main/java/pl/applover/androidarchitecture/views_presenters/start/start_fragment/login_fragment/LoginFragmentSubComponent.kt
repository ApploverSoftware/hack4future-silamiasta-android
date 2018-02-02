package pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Janusz Hain on 2018-02-02.
 */
@Subcomponent(modules = arrayOf(LoginFragmentModule::class, LoginFragmentSubComponent::class))
interface LoginFragmentSubComponent : AndroidInjector<LoginFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginFragment>()

}