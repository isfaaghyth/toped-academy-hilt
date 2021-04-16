package app.topedacademy.productdagger.di.module

import app.topedacademy.network.Network
import app.topedacademy.productdagger.data.ProductServices
import app.topedacademy.productdagger.data.repository.ProductRepository
import app.topedacademy.productdagger.data.repository.ProductRepositoryImpl
import app.topedacademy.productdagger.di.ProductDaggerScope
import dagger.Module
import dagger.Provides

@Module
class ProductDaggerModule {

    @Provides
    @ProductDaggerScope
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @ProductDaggerScope
    fun provideRepository(
        services: ProductServices
    ): ProductRepository = ProductRepositoryImpl(services)

}