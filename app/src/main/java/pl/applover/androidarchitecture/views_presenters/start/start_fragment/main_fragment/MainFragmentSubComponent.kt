package pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Janusz Hain on 2018-02-02.
 */
@Subcomponent(modules = arrayOf(MainFragmentModule::class))
interface MainFragmentSubComponent : AndroidInjector<MainFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainFragment>()

}