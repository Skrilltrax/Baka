package dev.skrilltrax.baka.di.module

import android.content.Context
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.skrilltrax.baka.di.scopes.AppScope
import javax.inject.Named

@Module
@ContributesTo(AppScope::class)
object AndroidModule {

  @Provides
  @Named("InternalFilesDirPath")
  fun provideInternalFilesDirectoryPath(context: Context): String {
    return context.filesDir.absolutePath
  }
}
