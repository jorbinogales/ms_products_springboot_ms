package com.productsktor

import com.productsktor.database.connectToDatabase
import com.productsktor.plugins.configureRouting
import com.productsktor.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.productsktor.plugins.*
import com.productsktor.tables.Products
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    connectToDatabase()
    transaction {
        SchemaUtils.create(Products)
    }
    configureSerialization()
    configureRouting()
}
