package io.codefundo.donet.core

import androidx.lifecycle.LiveData

interface UseCase<I: Any, O: Any> {
    fun execute(vararg args: I): LiveData<O>
}