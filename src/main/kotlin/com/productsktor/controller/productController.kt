package com.productsktor.controller

import com.productsktor.service.ProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class ProductRequest(val name: String, val price: Double)

fun Route.productRoutes(productService: ProductService) {
    route("/products") {
        get {
            // Obtener todos los productos
            val products = productService.getAllAvailableProducts()
            call.respond(products)
        }
        post {
            // Crear un nuevo producto
            val request = call.receive<ProductRequest>()
            val product = productService.addProduct(request.name, request.price)
            call.respond(HttpStatusCode.Created, product)
        }
    }
}