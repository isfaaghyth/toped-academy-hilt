package app.topedacademy.producthilt.di

import app.topedacademy.producthilt.di.module.CoroutineModule
import app.topedacademy.producthilt.di.module.ProductHiltModule
import app.topedacademy.producthilt.di.module.ProductHiltViewModelModule
import app.topedacademy.producthilt.ui.ProductHiltFragment
import dagger.Component

@Component(
    modules = [
        CoroutineModule::class,
        ProductHiltModule::class,
        ProductHiltViewModelModule::class
    ]
)
interface ProductHiltComponent {
    fun inject(fragment: ProductHiltFragment)
}