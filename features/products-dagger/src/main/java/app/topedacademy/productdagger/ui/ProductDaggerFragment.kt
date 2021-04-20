package app.topedacademy.productdagger.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.topedacademy.abstraction.base.BaseFragment
import app.topedacademy.productdagger.databinding.FragmentProductDaggerBinding
import app.topedacademy.productdagger.ui.adapter.ProductAdapter

class ProductDaggerFragment : BaseFragment() {

    private var _binding: FragmentProductDaggerBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductDaggerViewModel

    private val adapter by lazy { ProductAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ProductDaggerViewModel::class.java)
    }

}