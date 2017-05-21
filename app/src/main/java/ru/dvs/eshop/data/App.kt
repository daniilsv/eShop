package ru.dvs.eshop.data

import android.app.Application

import java.io.IOException

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dvs.eshop.data.network.Api

class App : Application() {
    private var retrofit: Retrofit? = null

    override fun onCreate() {
        super.onCreate()

        val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()

                    // Request customization: add request headers
                    val requestBuilder = original.newBuilder()
                            .header("api_key", "f3447eebfe018f62a4098aea2f26f44b")
                            .method(original.method(), original.body())

                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl("https://daniils.ru/api/method/") //Базовая часть адреса
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build()
        api = retrofit!!.create(Api::class.java) //Создаем объект, при помощи которого будем выполнять запросы
    }

    companion object {

        var api: Api? = null
            private set
    }
}