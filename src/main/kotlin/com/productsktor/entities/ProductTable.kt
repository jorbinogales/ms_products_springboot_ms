package com.productsktor.tables

import org.jetbrains.exposed.sql.Table

object Products : Table("products") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val price = double("price")
    val available = bool("available").default(true)

    override val primaryKey = PrimaryKey(id)
}