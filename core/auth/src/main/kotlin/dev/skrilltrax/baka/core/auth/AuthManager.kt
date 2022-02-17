package dev.skrilltrax.baka.core.auth

import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStoreFactory

public class AuthManager() {
    val authDataStore = DataStoreFactory.create(seAuthSerializer, migrations)

    private companion object {
        private val migrations = listOf<DataMigration<Auth>>()
    }
}