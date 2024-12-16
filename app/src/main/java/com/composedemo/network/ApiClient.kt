//package com.composedemo.network
//
//import com.composedemo.network.ApiService
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
//@Singleton
//class ApiClient {
//
//
//    val apiService: ApiService
//
//    init {
//        val logging = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val okHttpClientBuilder = OkHttpClient.Builder()
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .readTimeout(60, TimeUnit.SECONDS)
//            .writeTimeout(60, TimeUnit.SECONDS)
//            .addInterceptor(logging)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(API_BASE_URL_DEV)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClientBuilder)
//            .build()
//
//        apiService = retrofit.create(ApiService::class.java)
//
//    }
//
//
//    companion object {
//        private const val API_BASE_URL_DEV = "https://cdn.dummyjson.com/"
//        private const val API_BASE_URL_PROD = "https://cdn.dummyjson.com/"
//    }
//}