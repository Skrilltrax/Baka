package dev.skrilltrax.baka.di.component

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dev.skrilltrax.baka.MainActivity
import dev.skrilltrax.baka.di.module.ContextModule
import dev.skrilltrax.baka.di.scopes.AppCoroutineScope
import dev.skrilltrax.baka.di.scopes.AppScope
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope

@Singleton
@MergeComponent(scope = AppScope::class, modules = [ContextModule::class])
interface AppComponent {

  fun inject(activity: MainActivity)

  @Component.Builder
  interface Builder {

    @BindsInstance fun application(application: Application): Builder

    @BindsInstance
    fun applicationCoroutineScope(
      @AppCoroutineScope applicationCoroutineScope: CoroutineScope
    ): Builder

    fun build(): AppComponent
  }
}
