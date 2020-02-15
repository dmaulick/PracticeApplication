package com.example.practiceapplication.MainFeature

import java.lang.Exception

class Resource<T> private constructor(val status: Status,
                                      val data: T? = null,
                                      val exception: Exception? = null) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> loading(): Resource<T> = Resource(Status.LOADING, null, null)
        fun <T> error(exception: Exception?): Resource<T> = Resource(Status.ERROR, null, exception)
    }
}

enum class Status {
    SUCCESS,
    LOADING,
    ERROR
}