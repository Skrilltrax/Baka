package dev.skrilltrax.baka

import android.app.Application
import dev.skrilltrax.baka.di.component.AppComponent
import dev.skrilltrax.baka.di.component.DaggerAppComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class BakaApplication : Application() {

  private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder()
        .application(this)
        .applicationCoroutineScope(coroutineScope)
        .build()
  }

  companion object {
    lateinit var appComponent: AppComponent
  }
}
