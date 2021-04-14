package com.topedacademy.product.uimodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SellerUIModel(
    val id: Int = 0,
    val name: String = "",
    val location: String = "",
    val type: String = "",
    val badge: String = "",
    val avatar: String = "",
) : Parcelable