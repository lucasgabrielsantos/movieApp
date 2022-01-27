package com.lucas.network

import retrofit2.Retrofit

internal class ServiceFactoryImpl(
    private val retrofit: Retrofit
) : ServiceFactory {

    override fun <T> create(service: Class<T>): T = retrofit.create(service)
}
