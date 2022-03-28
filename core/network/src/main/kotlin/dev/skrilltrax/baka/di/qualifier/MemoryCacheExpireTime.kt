package dev.skrilltrax.baka.di.qualifier

import javax.inject.Qualifier

/** Qualifies a [Long] representing the memory cache expire time */
@Qualifier @Retention(AnnotationRetention.RUNTIME) internal annotation class MemoryCacheExpireTime
