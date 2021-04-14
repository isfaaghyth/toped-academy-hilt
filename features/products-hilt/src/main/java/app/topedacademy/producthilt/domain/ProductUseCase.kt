package app.topedacademy.producthilt.domain

import app.topedacademy.abstraction.base.UseCase
import app.topedacademy.abstraction.di.IoDispatcher
import app.topedacademy.producthilt.repository.ProductRepository
import com.topedacademy.product.mapper.mapTo
import com.topedacademy.product.uimodel.ProductUIModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ProductUseCase @Inject constructor(
    private val repository: ProductRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Any, List<ProductUIModel>>(dispatcher) {

    override suspend fun execute(param: Any): List<ProductUIModel> {
        val products = repository.getProducts()
        return mapTo(products)
    }

}