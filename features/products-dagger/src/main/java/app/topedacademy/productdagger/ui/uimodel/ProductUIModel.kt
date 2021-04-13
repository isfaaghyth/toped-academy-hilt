package app.topedacademy.productdagger.ui.uimodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductUIModel(
    val id: Int,
    val name: String = "",
    val banner: String = "",
    val link: String = "",
    val price: String = "",
    val seller: SellerUIModel = SellerUIModel(),
) : Parcelable