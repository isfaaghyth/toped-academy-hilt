package com.topedacademy.product

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Products(
    @Expose @SerializedName("status") val status: String,
    @Expose @SerializedName("total") val total: Int,
    @Expose @SerializedName("products") val products: List<Product>,
)

data class Product(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("banner") val banner: String,
    @Expose @SerializedName("link") val link: String,
    @Expose @SerializedName("price") val price: String,
    @Expose @SerializedName("seller") val seller: Seller,
)

data class Seller(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("location") val location: String,
    @Expose @SerializedName("type") val type: String,
    @Expose @SerializedName("badge") val badge: String,
    @Expose @SerializedName("avatar") val avatar: String,
)
