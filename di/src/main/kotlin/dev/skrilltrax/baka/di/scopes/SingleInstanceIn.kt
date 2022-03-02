package dev.skrilltrax.baka.di.scopes

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
public annotation class SingleInstanceIn(val scope: KClass<*>)
