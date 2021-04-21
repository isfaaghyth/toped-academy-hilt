package app.topedacademy.producthilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.topedacademy.abstraction.base.BaseFragment
import app.topedacademy.producthilt.databinding.FragmentProductHiltBinding
import app.topedacademy.producthilt.di.DaggerProductHiltComponent
import app.topedacademy.producthilt.di.module.CoroutineModule
import app.topedacademy.producthilt.di.module.ProductHiltModule
import app.topedacademy.producthilt.ui.adapter.ProductAdapter
import javax.inject.Inject

class ProductHiltFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentProductHiltBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductHiltViewModel by activityViewModels { viewModelFactory }
    private val adapter by lazy { ProductAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()

        _binding = FragmentProductHiltBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun initView(savedInstanceState: Bundle?) {
        // setup recyclerView
        binding.lstProduct.adapter = adapter

        // fetch data of product list
        viewModel.getProducts()
    }

    override fun initObservable() {
        viewModel.products.observe(this, Observer {
            adapter.add(it.reversed())
        })

        viewModel.errorMessage.observe(this, Observer {
            toast(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun inject() {
        DaggerProductHiltComponent
            .builder()
            .coroutineModule(CoroutineModule())
            .productHiltModule(ProductHiltModule())
            .build()
            .inject(this)
    }

}