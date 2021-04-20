package app.topedacademy.productmanual.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.topedacademy.product.uimodel.ProductUIModel
import kotlinx.coroutines.launch

class ProductManualViewModel : ViewModel() {

    private val _products = MutableLiveData<List<ProductUIModel>>()
    val products: LiveData<List<ProductUIModel>> get() = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getProducts() {
        viewModelScope.launch {

        }
    }

}