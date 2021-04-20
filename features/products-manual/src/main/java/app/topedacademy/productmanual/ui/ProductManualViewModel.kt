package app.topedacademy.productmanual.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.topedacademy.abstraction.data.Result
import app.topedacademy.abstraction.data.successOr
import app.topedacademy.network.Network
import app.topedacademy.productmanual.data.ProductServices
import app.topedacademy.productmanual.data.repository.ProductRepositoryImpl
import app.topedacademy.productmanual.domain.ProductUseCase
import app.topedacademy.productmanual.factory.ProductFactory
import com.topedacademy.product.uimodel.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductManualViewModel : ViewModel() {

    private var useCase: ProductUseCase = ProductFactory().buildProductUseCase()

    private val _products = MutableLiveData<List<ProductUIModel>>()
    val products: LiveData<List<ProductUIModel>> get() = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getProducts() {
        viewModelScope.launch {
            when (val result = useCase(Unit)) {
                is Result.Success -> _products.value = result.successOr(emptyList())
                is Result.Error -> _errorMessage.postValue(result.throwable.toString())
            }
        }
    }

    private fun buildUseCase(): ProductUseCase {
        return ProductUseCase(
            repository = ProductRepositoryImpl(
                services = Network.builder().create(ProductServices::class.java)
            ),
            dispatcher = Dispatchers.IO
        )
    }

}