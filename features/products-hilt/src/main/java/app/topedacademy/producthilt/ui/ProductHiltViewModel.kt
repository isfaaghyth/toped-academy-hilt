package app.topedacademy.producthilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.topedacademy.abstraction.data.Result
import app.topedacademy.abstraction.data.successOr
import app.topedacademy.producthilt.domain.ProductUseCase
import com.topedacademy.product.uimodel.ProductUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ProductHiltContract {
    fun getProducts()
}

@HiltViewModel
class ProductHiltViewModel @Inject constructor(
    private val useCase: ProductUseCase
) : ViewModel(), ProductHiltContract {

    private val _products = MutableLiveData<List<ProductUIModel>>()
    val products: LiveData<List<ProductUIModel>> get() = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    override fun getProducts() {
        viewModelScope.launch {
            when (val result = useCase(Unit)) {
                is Result.Success -> _products.value = result.successOr(emptyList())
                is Result.Error -> _errorMessage.postValue(result.throwable.toString())
            }
        }
    }

}