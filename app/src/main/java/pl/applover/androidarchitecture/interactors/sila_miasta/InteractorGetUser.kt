package pl.applover.androidarchitecture.interactors.sila_miasta

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import pl.applover.androidarchitecture.App
import pl.applover.androidarchitecture.data.example.internet.api_endpoints.ApiEndpointsSilaMiasta
import pl.applover.androidarchitecture.data.example.internet.params.ParamsGetUser
import pl.applover.androidarchitecture.data.example.internet.response.ResponseCheckUser
import pl.applover.androidarchitecture.util.MyScheduler
import pl.applover.androidarchitecture.util.extensions.printError
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by Janusz Hain on 2018-01-10.
 */
class InteractorGetUser(private val retrofit: Retrofit = App.getMainRetrofit()) {

    private var disposable: Disposable? = null

    fun execute(onSuccess: (responseCheckUser: ResponseCheckUser) -> Unit, onFailure: (code: Int?) -> Unit, paramsGetUser: ParamsGetUser) {
        disposable = getSingle(retrofit, paramsGetUser).subscribe({
            if (it.isSuccessful) {
                it.body()?.let {
                    onSuccess(it)
                } ?: run {
                    onFailure(null)
                }
            } else {
                onFailure(it.code())
            }
        }, { throwable ->
            printError(this, throwable)
            onFailure(null)
        })
    }

    fun unsubscribe() {
        disposable?.dispose()
    }

    companion object {
        fun getSingle(retrofit: Retrofit, paramsGetUser: ParamsGetUser): Single<Response<ResponseCheckUser>> { //todo create Response
            val api = retrofit.create<ApiEndpointsSilaMiasta>(ApiEndpointsSilaMiasta::class.java)

            return api.getUser(paramsGetUser.userName)
                    .observeOn(MyScheduler.getMainThreadScheduler())
                    .subscribeOn(MyScheduler.getScheduler())
        }
    }


}