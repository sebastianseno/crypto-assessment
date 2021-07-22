package com.crypto.mainmenu.network.module

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

object ResponseJsonChecker : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        return Converter<ResponseBody, Any> {
            val delegate = retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
            try {
                delegate.convert(it)
            } catch (error: Exception) {
                throw IOException("Ups, terjadi kesalahan")
            }
        }
    }
}