package com.lucas.network

interface ServiceFactory {

    fun <T> create(service: Class<T>): T
}
