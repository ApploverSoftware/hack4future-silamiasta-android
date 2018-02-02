package pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by kroll on 02.02.18.
 */
@Subcomponent(modules = arrayOf(SecondFragmentModule::class))
interface SecondFragmentSubComponent : AndroidInjector<SecondFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SecondFragment>()

    //TODO REMINDER: move the line below to FragmentsInjectorFactories's @Module(...) annotation
    //SecondFragmentSubComponent::class

    //TODO REMINDER: move this to FragmentsInjectorFactories module

}