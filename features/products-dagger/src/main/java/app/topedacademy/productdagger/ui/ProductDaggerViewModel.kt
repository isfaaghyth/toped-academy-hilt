package app.topedacademy.productdagger.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.topedacademy.abstraction.data.Result
import app.topedacademy.productdagger.domain.ProductUseCase
import com.topedacademy.product.uimodel.ProductUIModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ProductDaggerContract {
    fun getProducts()
}

class ProductDaggerViewModel @Inject constructor(
    private val useCase: ProductUseCase
) : ViewModel(), ProductDaggerContract {

    private val _products = MutableLiveData<List<ProductUIModel>>()
    val products: LiveData<List<ProductUIModel>> get() = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    override fun getProducts() {
        viewModelScope.launch {
            when (val result = useCase(Unit)) {
                is Result.Success -> _products.value = result.data
                is Result.Error -> _errorMessage.postValue(result.throwable.toString())
            }
        }
    }

}