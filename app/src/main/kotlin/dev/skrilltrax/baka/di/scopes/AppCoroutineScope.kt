package dev.skrilltrax.baka.di.scopes

import javax.inject.Scope

/** Identifies a coroutine scope type that is scope to the app lifecycle */
@Scope @MustBeDocumented @Retention(AnnotationRetention.RUNTIME) annotation class AppCoroutineScope
