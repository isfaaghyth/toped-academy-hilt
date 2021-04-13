package app.topedacademy

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(
            ImageLoader.Builder(applicationContext)
                .componentRegistry {
                    add(SvgDecoder(applicationContext))
                }
                .build()
        )
    }

}