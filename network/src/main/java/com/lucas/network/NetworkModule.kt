package com.lucas.network

import org.koin.dsl.module

val networkModule = module {
    single<ServiceFactory> { ServiceFactoryImpl(RetrofitConfig.create()) }
}
