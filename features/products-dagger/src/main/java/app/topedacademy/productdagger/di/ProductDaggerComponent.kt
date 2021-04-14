package app.topedacademy.productdagger.di

import app.topedacademy.abstraction.di.CoroutineModule
import app.topedacademy.productdagger.di.module.ProductDaggerModule
import app.topedacademy.productdagger.di.module.ProductDaggerViewModelModule
import app.topedacademy.productdagger.ui.ProductDaggerFragment
import dagger.Component

@ProductDaggerScope
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