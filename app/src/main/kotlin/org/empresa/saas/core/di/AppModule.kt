package org.empresa.saas.core.di

import org.empresa.saas.presentation.feature_auth.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
}
