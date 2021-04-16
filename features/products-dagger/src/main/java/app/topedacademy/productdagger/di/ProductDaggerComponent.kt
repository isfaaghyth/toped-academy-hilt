package app.topedacademy.productdagger.di

import app.topedacademy.productdagger.di.module.CoroutineModule
import app.topedacademy.productdagger.di.module.ProductDaggerModule
import app.topedacademy.productdagger.di.module.ProductDaggerViewModelModule
import app.topedacademy.productdagger.ui.ProductDaggerFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoroutineModule::class,
        ProductDaggerModule::class,
        ProductDaggerViewModelModule::class
    ]
)
interface ProductDaggerComponent {
    fun inject(fragment: ProductDaggerFragment)
}