package pl.applover.androidarchitecture.interactors.sila_miasta

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import pl.applover.androidarchitecture.App
import pl.applover.androidarchitecture.data.example.internet.api_endpoints.ApiEndpointsSilaMiasta
import pl.applover.androidarchitecture.data.example.internet.params.ParamsCreateFacebookAsset
import pl.applover.androidarchitecture.util.MyScheduler
import pl.applover.androidarchitecture.util.extensions.printError
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by Janusz Hain on 2018-01-10.
 */
class InteractorCreateFacebookAsset(private val retrofit: Retrofit = App.getMainRetrofit()) {

    private var disposable: Disposable? = null

    fun execute(onSuccess: () -> Unit, onFailure: (code: Int?) -> Unit, paramsCreateFacebookAsset: ParamsCreateFacebookAsset) {
        disposable = getSingle(retrofit, paramsCreateFacebookAsset).subscribe({
            if (it.isSuccessful) {
                it.body()?.let {
                    onSuccess()
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
        fun getSingle(retrofit: Retrofit, paramsCreateFacebookAsset: ParamsCreateFacebookAsset): Single<Response<Void>> {
            val api = retrofit.create<ApiEndpointsSilaMiasta>(ApiEndpointsSilaMiasta::class.java)

            return api.createFacebookAsset(paramsCreateFacebookAsset.paramsBody) //it can be api.getExampleList(paramsExample.userId) too as we got default value set in getExampleList
                    .observeOn(MyScheduler.getMainThreadScheduler())
                    .subscribeOn(MyScheduler.getScheduler())
        }
    }


}