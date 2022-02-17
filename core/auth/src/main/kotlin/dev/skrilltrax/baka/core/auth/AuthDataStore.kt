package dev.skrilltrax.baka.core.auth

import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStoreFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.io.File

private const val FILE_NAME = "auth.pb"
private val migrations: List<DataMigration<Auth>> = emptyList()

internal fun createAuthDataStore(directory: File) = DataStoreFactory.create(
    serializer = AuthSerializer,
    corruptionHandler = null,
    migrations = migrations,
    scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
    produceFile = { File(directory, FILE_NAME) }
)