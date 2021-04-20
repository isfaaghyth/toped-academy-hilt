package app.topedacademy.productmanual.factory

import app.topedacademy.network.Network
import app.topedacademy.productmanual.data.ProductServices
import app.topedacademy.productmanual.data.repository.ProductRepository
import app.topedacademy.productmanual.data.repository.ProductRepositoryImpl
import app.topedacademy.productmanual.domain.ProductUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


/**
 * Created by mzennis on 20/04/21.
 */
class ProductFactory {

    private fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    private fun provideProductRepository(services: ProductServices): ProductRepository {
        return ProductRepositoryImpl(services)
    }

    private fun provideProductUseCase(repository: ProductRepository, coroutineDispatcher: CoroutineDispatcher): ProductUseCase {
        return ProductUseCase(repository, coroutineDispatcher)
    }

    fun buildUseCase(): ProductUseCase {
        return provideProductUseCase(
            repository = provideProductRepository(
                services = provideProductServices()
            ),
            coroutineDispatcher = Dispatchers.IO
        )
    }
}