package io.codefundo.donet.domain

sealed class Resource {
    class Success<T : Any>(val data: T) : Resource()

    class Failure(val message: String) : Resource()

    class Loading(val message: String) : Resource()
}
