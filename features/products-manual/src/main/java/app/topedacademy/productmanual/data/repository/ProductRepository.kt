package app.topedacademy.productmanual.data.repository

import app.topedacademy.productmanual.data.ProductServices
import com.topedacademy.product.entity.Products

interface ProductRepository {
    suspend fun getProducts(): Products
}

open class ProductRepositoryImpl constructor(
    private val services: ProductServices
) : ProductRepository {

    override suspend fun getProducts(): Products {
        return services.getProducts()
    }

}