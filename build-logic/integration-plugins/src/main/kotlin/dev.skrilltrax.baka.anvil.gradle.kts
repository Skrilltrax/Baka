import com.squareup.anvil.plugin.AnvilExtension

plugins { id("com.squareup.anvil") }

extensions.configure<AnvilExtension> { generateDaggerFactories.set(true) }
