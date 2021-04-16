package app.topedacademy.productdagger.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.topedacademy.abstraction.viewmodel.ViewModelFactory
import app.topedacademy.abstraction.viewmodel.ViewModelKey
import app.topedacademy.productdagger.ui.ProductDaggerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ProductDaggerViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductDaggerViewModel::class)
    internal abstract fun bindMovieViewModel(viewModel: ProductDaggerViewModel): ViewModel

}