package com.productsktor.plugins

import com.productsktor.controller.productRoutes
import com.productsktor.service.ProductService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        productRoutes(ProductService())
    }
}
