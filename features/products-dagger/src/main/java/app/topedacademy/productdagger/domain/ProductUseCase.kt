package app.topedacademy.productdagger.domain

import app.topedacademy.abstraction.base.UseCase
import app.topedacademy.productdagger.data.repository.ProductRepository
import com.topedacademy.product.mapper.mapTo
import com.topedacademy.product.uimodel.ProductUIModel
import kotlinx.coroutines.CoroutineDispatcher

open class ProductUseCase constructor(
    private val repository: ProductRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Any, List<ProductUIModel>>(dispatcher) {

    override suspend fun execute(param: Any): List<ProductUIModel> {
        val products = repository.getProducts()
        return mapTo(products)
    }

}