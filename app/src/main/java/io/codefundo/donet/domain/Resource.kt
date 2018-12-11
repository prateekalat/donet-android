package io.codefundo.donet.domain

import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy

/**
 * Wrapper class for any "resource" being obtained from a repository.
 */
sealed class Resource {
    class Success<T : Any>(val data: T) : Resource()

    class Failure(val throwable: Throwable) : Resource()

    class Loading(val message: String) : Resource()
}

/**
 * Utility method which updates a [liveData]'s value with a [Resource] object.
 *
 * @param liveData [MutableLiveData] to update after result is obtained
 */
fun <T: Any> Single<T>.subscribeWithLiveData(liveData: MutableLiveData<Resource>) =
        subscribeBy(
                onError = {
                    liveData.value = Resource.Failure(it)
                },

                onSuccess = {
                    liveData.value = Resource.Success(it)
                }
        )

