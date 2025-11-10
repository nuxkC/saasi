package org.empresa.saas.core.di

import org.empresa.saas.domain.usecase.auth.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
}
