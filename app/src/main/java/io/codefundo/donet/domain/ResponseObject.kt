package io.codefundo.donet.domain

sealed class ResponseObject

class Success<T>(val data: T) : ResponseObject()

class Failure(val message: String) : ResponseObject()
