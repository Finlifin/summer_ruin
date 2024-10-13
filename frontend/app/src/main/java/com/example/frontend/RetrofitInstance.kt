package com.example.frontend


import com.example.frontend.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

//    private const val BASE_URL = "http://10.70.143.168:8001"
    private const val BASE_URL = "http://10.33.13.3:8001"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

object ImageRetrofitInstance {

//    private const val IMAGE_URL = "http://10.70.143.168:8000"
    private const val IMAGE_URL = "http://10.33.13.3:8000"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(IMAGE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
