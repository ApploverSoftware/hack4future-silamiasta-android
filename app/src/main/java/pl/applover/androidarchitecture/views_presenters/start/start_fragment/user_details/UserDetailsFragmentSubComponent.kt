package pl.applover.androidarchitecture.views_presenters.start.start_fragment.user_details

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Janusz Hain on 2018-02-03.
 */
@Subcomponent(modules = arrayOf(UserDetailsFragmentModule::class))
interface UserDetailsFragmentSubComponent : AndroidInjector<UserDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<UserDetailsFragment>()

}