package dev.skrilltrax.baka.di.module

import android.app.Application
import android.content.Context
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dev.skrilltrax.baka.di.scopes.AppScope
import dev.skrilltrax.baka.di.scopes.SingleInstanceIn
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
abstract class ContextModule {

  @Singleton
  @Binds
  abstract fun bindsContext(application: Application): Context
}
