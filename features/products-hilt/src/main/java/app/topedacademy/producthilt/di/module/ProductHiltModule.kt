package app.topedacademy.producthilt.di.module

import app.topedacademy.network.Network
import app.topedacademy.producthilt.di.ProductHiltScope
import app.topedacademy.producthilt.repository.ProductRepository
import app.topedacademy.producthilt.repository.ProductRepositoryImpl
import com.topedacademy.product.ProductServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductHiltModule {

    @Provides
    @ProductHiltScope
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @ProductHiltScope
    fun provideRepository(
            services: ProductServices
    ): ProductRepository
            = ProductRepositoryImpl(services)

}