package com.productsktor.database

import org.jetbrains.exposed.sql.Database

fun connectToDatabase() {
    val host = System.getenv("DB_HOST") ?: "localhost"
    val port = System.getenv("DB_PORT") ?: "5432"
    val dbName = System.getenv("DB_NAME") ?: "database"
    val user = System.getenv("DB_USER") ?: "user"
    val password = System.getenv("DB_PASSWORD") ?: "password"
    Database.connect(
        url = "jdbc:postgresql://$host:$port/$dbName",
        driver = "org.postgresql.Driver",
        user = user,
        password = password
    )
}