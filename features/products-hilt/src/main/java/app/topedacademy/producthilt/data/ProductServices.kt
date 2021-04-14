package app.topedacademy.producthilt.data

import com.topedacademy.product.entity.Products
import retrofit2.http.GET

interface ProductServices {

    @GET("2a7439499cfd4d8142434a4c522edede/raw/b813ed416ee9fc251c208ff492981153f258ed63/products.json")
    suspend fun getProducts(): Products

}