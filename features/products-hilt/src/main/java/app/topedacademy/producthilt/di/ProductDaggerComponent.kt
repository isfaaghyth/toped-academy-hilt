package app.topedacademy.producthilt.di

import app.topedacademy.producthilt.di.module.CoroutineModule
import app.topedacademy.producthilt.di.module.ProductDaggerModule
import app.topedacademy.producthilt.di.module.ProductDaggerViewModelModule
import app.topedacademy.producthilt.ui.ProductHiltFragment
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
    fun inject(fragment: ProductHiltFragment)
}