package com.android.network.utils

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val movieAppDispatchers: MovieAppDispatchers)

enum class MovieAppDispatchers {
    IO,
}