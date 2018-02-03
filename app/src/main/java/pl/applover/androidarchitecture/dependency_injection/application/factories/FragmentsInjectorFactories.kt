package pl.applover.androidarchitecture.dependency_injection.application.factories


import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import pl.applover.androidarchitecture.views_presenters.example.main.dialog_fragment.ExampleDialogFragment
import pl.applover.androidarchitecture.views_presenters.example.main.dialog_fragment.ExampleDialogFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.StartFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.StartFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment.CheckUserFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.check_user_fragment.CheckUserFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification.CodeVerificationFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.code_verification.CodeVerificationFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.login_fragment.LoginFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment.MainFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.main_fragment.MainFragmentSubComponent
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment.SecondFragment
import pl.applover.androidarchitecture.views_presenters.start.start_fragment.second_fragment.SecondFragmentSubComponent


/**
 * Created by Janusz Hain on 2018-01-08.
 */
@Module(subcomponents = arrayOf(
//TODO        register your fragments' subcomponents here
        StartFragmentSubComponent::class,
        ExampleDialogFragmentSubComponent::class,
        SecondFragmentSubComponent::class,
        CodeVerificationFragmentSubComponent::class,
        LoginFragmentSubComponent::class,
        MainFragmentSubComponent::class,
        CheckUserFragmentSubComponent::class
))
abstract class FragmentsInjectorFactories {

    //TODO bind your fragments' injection factories here

    @Binds
    @IntoMap
    @FragmentKey(StartFragment::class)
    internal abstract fun bindStartFragmentInjectorFactory(builder: StartFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(ExampleDialogFragment::class)
    internal abstract fun bindExampleDialogFragmentInjectorFactory(builder: ExampleDialogFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(SecondFragment::class)
    internal abstract fun bindSecondFragmentInjectorFactory(builder: SecondFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(CodeVerificationFragment::class)
    internal abstract fun bindCodeVerificationFragmentInjectorFactory(builder: CodeVerificationFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(LoginFragment::class)
    internal abstract fun bindLoginFragmentInjectorFactory(builder: LoginFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    internal abstract fun bindMainFragmentInjectorFactory(builder: MainFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(CheckUserFragment::class)
    internal abstract fun bindCheckUserFragmentInjectorFactory(builder: CheckUserFragmentSubComponent.Builder):
            AndroidInjector.Factory<out Fragment>
}