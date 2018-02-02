package pl.applover.androidarchitecture.views_presenters.start.codeVerification

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by kroll on 02.02.18.
 */
@Subcomponent(modules = arrayOf(CodeVerificationFragmentModule::class))
interface CodeVerificationFragmentSubComponent : AndroidInjector<CodeVerificationFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CodeVerificationFragment>()

    //TODO REMINDER: move the line below to FragmentsInjectorFactories's @Module(...) annotation
    //CodeVerificationFragmentSubComponent::class

    //TODO REMINDER: move this to FragmentsInjectorFactories module

}