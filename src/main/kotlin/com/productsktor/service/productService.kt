package com.productsktor.service

import com.productsktor.models.Product
import com.productsktor.tables.Products
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal


class ProductService {

    init {
        transaction {
            SchemaUtils.create(Products)
        }
    }

    fun addProduct(name: String, price: Double, available: Boolean = true): Product {
        var productId: Int = -1
        transaction {
            productId = Products.insert { statement ->
                statement[Products.name] = name
                statement[Products.price] = price
                statement[Products.available] = available
            } get Products.id
        }
        return Product(productId, name, price, available)
    }

    fun getAllAvailableProducts(): List<Product> {
        return transaction {
            Products.select() { Products.available eq true }
                .map { rowToProduct(it) }
        }
    }

    private fun rowToProduct(row: ResultRow): Product {
        return Product(
            id = row[Products.id],
            name = row[Products.name],
            price = row[Products.price],
            available = row[Products.available]
        )
    }
}