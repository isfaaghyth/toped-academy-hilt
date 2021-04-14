package app.topedacademy.productdagger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.topedacademy.abstraction.base.BaseFragment
import app.topedacademy.productdagger.databinding.FragmentProductDaggerBinding
import app.topedacademy.productdagger.di.DaggerProductDaggerComponent
import app.topedacademy.productdagger.di.module.CoroutineModule
import app.topedacademy.productdagger.di.module.ProductDaggerModule
import app.topedacademy.productdagger.ui.adapter.ProductAdapter
import javax.inject.Inject

class ProductDaggerFragment : BaseFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentProductDaggerBinding? = null
    private val binding get() = _binding!!

    private val viewModel:ProductDaggerViewModel by activityViewModels { viewModelFactory }
    private val adapter by lazy { ProductAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()

        _binding = FragmentProductDaggerBinding.inflate(
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
            adapter.add(it)
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
        DaggerProductDaggerComponent
            .builder()
            .coroutineModule(CoroutineModule())
            .productDaggerModule(ProductDaggerModule())
            .build()
            .inject(this)
    }

}