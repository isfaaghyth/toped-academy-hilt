package app.topedacademy.abstraction.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T: ViewModel> Fragment.viewModels(
    factory: ViewModelProvider.Factory
) = ViewModelProvider(
    this,
    factory
).get(T::class.java)