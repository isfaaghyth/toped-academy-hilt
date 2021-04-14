package app.topedacademy.producthilt.repository

import com.topedacademy.product.ProductServices
import com.topedacademy.product.entity.Products
import javax.inject.Inject

interface ProductRepository {
    suspend fun getProducts(): Products
}

open class ProductRepositoryImpl @Inject constructor(
    private val services: ProductServices
) : ProductRepository {

    override suspend fun getProducts(): Products {
        return services.getProducts()
    }

}