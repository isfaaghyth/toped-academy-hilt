package app.topedacademy.producthilt.di.module

import app.topedacademy.network.Network
import app.topedacademy.producthilt.data.ProductServices
import app.topedacademy.producthilt.data.repository.ProductRepository
import app.topedacademy.producthilt.data.repository.ProductRepositoryImpl
import app.topedacademy.producthilt.di.ProductDaggerScope
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