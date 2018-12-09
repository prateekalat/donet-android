package io.codefundo.donet.domain

import androidx.lifecycle.LiveData

interface UseCase<I: Any, O: Any> {
    fun execute(vararg args: I): LiveData<O>
}