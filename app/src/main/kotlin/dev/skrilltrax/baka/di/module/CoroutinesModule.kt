package dev.skrilltrax.baka.di.module

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.skrilltrax.baka.di.scopes.AppScope
import javax.inject.Named
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@ContributesTo(AppScope::class)
object CoroutinesModule {

  @Provides
  @Named("MainDispatcher")
  fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

  @Provides @Named("DefaultDispatcher") fun providesDefaultDispatcher() = Dispatchers.Default

  @Provides @Named("IoDispatcher") fun providesIoDispatcher() = Dispatchers.IO
}
