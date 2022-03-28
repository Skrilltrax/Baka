package dev.skrilltrax.baka.di.qualifier

import javax.inject.Qualifier

/** Qualifies an [Int] representing the memory cache size limit */
@Qualifier @Retention(AnnotationRetention.RUNTIME) internal annotation class MemoryCacheSizeLimit
