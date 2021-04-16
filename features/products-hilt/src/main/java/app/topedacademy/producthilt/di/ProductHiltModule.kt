package app.topedacademy.producthilt.di

import app.topedacademy.network.Network
import app.topedacademy.producthilt.data.ProductServices
import app.topedacademy.producthilt.data.repository.ProductRepository
import app.topedacademy.producthilt.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ProductHiltModule {

    @Provides
    @ViewModelScoped
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @ViewModelScoped
    fun provideRepository(
            services: ProductServices
    ): ProductRepository
            = ProductRepositoryImpl(services)

}