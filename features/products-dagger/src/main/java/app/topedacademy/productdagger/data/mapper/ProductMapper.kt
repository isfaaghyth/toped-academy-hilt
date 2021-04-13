package app.topedacademy.productdagger.data.mapper

import app.topedacademy.productdagger.ui.uimodel.ProductUIModel
import app.topedacademy.productdagger.ui.uimodel.SellerUIModel
import com.topedacademy.product.Product
import com.topedacademy.product.Products
import com.topedacademy.product.Seller

fun mapTo(seller: Seller): SellerUIModel {
    return SellerUIModel(
        id = seller.id,
        name = seller.name,
        location = seller.location,
        type = seller.type,
        badge = seller.badge,
        avatar = seller.avatar,
    )
}

fun mapTo(product: Product): ProductUIModel {
    return ProductUIModel(
        id = product.id,
        name = product.name,
        banner = product.banner,
        link = product.link,
        price = product.price,
        seller = mapTo(product.seller),
    )
}

fun mapTo(product: Products): List<ProductUIModel> {
    return product.products.map {
        mapTo(it)
    }.toList()
}