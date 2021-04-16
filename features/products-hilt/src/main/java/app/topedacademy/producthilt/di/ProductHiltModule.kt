package app.topedacademy.producthilt.di

import app.topedacademy.network.Network
import app.topedacademy.producthilt.data.ProductServices
import app.topedacademy.producthilt.data.repository.ProductRepository
import app.topedacademy.producthilt.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ProductHiltModule {

    @Provides
    @ActivityScoped
    fun provideProductServices(): ProductServices
            = Network.builder().create(ProductServices::class.java)

    @Provides
    @ActivityScoped
    fun provideRepository(
            services: ProductServices
    ): ProductRepository
            = ProductRepositoryImpl(services)

}