package app.topedacademy.productdagger.di.module

import app.topedacademy.network.Network
import app.topedacademy.productdagger.data.ProductServices
import app.topedacademy.productdagger.data.repository.ProductRepository
import app.topedacademy.productdagger.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProductDaggerModule {

    @Provides
    @Singleton
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @Singleton
    fun provideRepository(
        services: ProductServices
    ): ProductRepository = ProductRepositoryImpl(services)

}