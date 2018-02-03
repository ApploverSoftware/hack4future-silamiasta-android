package pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Janusz Hain on 2018-02-03.
 */
@Subcomponent(modules = arrayOf(CheckUserFragmentModule::class))
interface CheckUserFragmentSubComponent : AndroidInjector<CheckUserFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CheckUserFragment>()

}