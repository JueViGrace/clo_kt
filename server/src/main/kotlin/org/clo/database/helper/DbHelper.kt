package org.clo.database.helper

import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.clo.CloServer
import org.clo.database.driver.DriverFactory

object DbHelper {
    private val driver: SqlDriver = DriverFactory.initDatabase()

    private var db: CloServer? = null

    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: (CloServer) -> Result): Result = mutex.withLock {
        if (db == null) {
            db = createDb()
        }

        return@withLock block(db!!)
    }

    private fun createDb(): CloServer {
        return CloServer(driver = driver)
    }
}
