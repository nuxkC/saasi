package org.empresa.saas.core.di

import org.empresa.saas.data.repository.AuthRepositoryImpl
import org.empresa.saas.domain.repository.AuthRepository
import org.koin.dsl.module

val dataModule = module {
    single<AuthRepository> { AuthRepositoryImpl() }
}
