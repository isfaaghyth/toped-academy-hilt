package app.topedacademy.producthilt.di

import app.topedacademy.network.Network
import app.topedacademy.producthilt.data.ProductServices
import app.topedacademy.producthilt.data.repository.ProductRepository
import app.topedacademy.producthilt.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductHiltModule {

    @Provides
    @Singleton
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @Singleton
    fun provideRepository(
            services: ProductServices
    ): ProductRepository
            = ProductRepositoryImpl(services)

}