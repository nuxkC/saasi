package org.empresa.saas

import android.app.Application
import org.empresa.saas.core.di.appModule
import org.empresa.saas.core.di.dataModule
import org.empresa.saas.core.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SaasApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SaasApplication)
            modules(appModule, domainModule, dataModule)
        }
    }
}
