package com.topedacademy.product.mapper

import com.topedacademy.product.uimodel.ProductUIModel
import com.topedacademy.product.uimodel.SellerUIModel
import com.topedacademy.product.entity.Product
import com.topedacademy.product.entity.Products
import com.topedacademy.product.entity.Seller

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