package app.topedacademy.producthilt.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.topedacademy.abstraction.viewmodel.ViewModelFactory
import app.topedacademy.abstraction.viewmodel.ViewModelKey
import app.topedacademy.producthilt.di.ProductDaggerScope
import app.topedacademy.producthilt.ui.ProductHiltViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductDaggerViewModelModule {

    @Binds
    @ProductDaggerScope
    abstract fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductHiltViewModel::class)
    internal abstract fun bindViewModel(viewModel: ProductHiltViewModel): ViewModel

}