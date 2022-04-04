package dev.skrilltrax.baka.di.qualifier

import javax.inject.Qualifier

/** Qualifies a [String] representing the base url of the api */
@Qualifier @Retention(AnnotationRetention.RUNTIME) internal annotation class BaseUrl
