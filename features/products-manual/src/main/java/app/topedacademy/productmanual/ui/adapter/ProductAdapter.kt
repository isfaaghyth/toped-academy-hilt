package app.topedacademy.productmanual.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.topedacademy.abstraction.databinding.ItemProductBinding
import com.topedacademy.product.uimodel.ProductUIModel
import coil.load

open class ProductAdapter constructor(
    private val products: MutableList<ProductUIModel> = mutableListOf()
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(ItemProductBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    fun add(items: List<ProductUIModel>) {
        products.clear()
        products.addAll(items)
        notifyDataSetChanged()
    }

    inner class ProductViewHolder constructor(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductUIModel) {
            binding.imgBanner.load(product.banner)
            binding.imgBadge.load(product.seller.badge)

            binding.txtName.text = product.name
            binding.txtPrice.text = product.price
            binding.txtSellerName.text = product.seller.name
        }

    }
}