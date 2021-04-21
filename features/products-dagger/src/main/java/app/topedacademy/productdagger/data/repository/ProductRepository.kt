package app.topedacademy.productdagger.data.repository

import app.topedacademy.productdagger.data.ProductServices
import com.topedacademy.product.entity.Products

interface ProductRepository {
    suspend fun getProducts(): Products
}

class ProductRepositoryImpl(
    private val services: ProductServices
) : ProductRepository {

    override suspend fun getProducts(): Products {
        return services.getProducts()
    }

}