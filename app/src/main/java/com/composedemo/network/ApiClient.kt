//package com.composetutorail.network
//
//import com.composetutorail.ApiService
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.Response
//import okhttp3.logging.HttpLoggingInterceptor
//import okhttp3.logging.HttpLoggingInterceptor.Level
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
//@Singleton
//class ApiClient {
//
//    companion object {
//        private const val API_BASE_URL_DEV = "https://cdn.dummyjson.com/"
//        private const val API_BASE_URL_PROD = "https://cdn.dummyjson.com/"
//    }
//
////    val apiService: ApiService
////
////    init {
//////        val okHttpClientBuilder = OkHttpClient.Builder()
//////            .connectTimeout(60, TimeUnit.SECONDS)
//////            .readTimeout(60, TimeUnit.SECONDS)
//////            .writeTimeout(60, TimeUnit.SECONDS)
//////            .addInterceptor(UserAgentHeaderInterceptor(buildInformation))
//////        if (BuildConfig.DEBUG) {
//////            val logger = HttpLoggingInterceptor().apply { level = Level.BODY }
//////            okHttpClientBuilder
//////                .addNetworkInterceptor(logger)
//////        }
//////
//////        okHttpClientBuilder.addInterceptor(AuthInterceptor(sessionManager))
////
//////        val apiBaseUrl = when (BuildConfig.FLAVOR) {
//////            "production" -> API_BASE_URL_PRODUCTION
//////            "internal" -> API_BASE_URL_INTERNAL
//////            "dev" -> API_BASE_URL_DEV
//////            else -> throw Exception("Invalid Build type")
//////        }
////
////        val retrofit = Retrofit.Builder()
////            .baseUrl(API_BASE_URL_DEV)
//////            .client(okHttpClientBuilder.build())
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////
////        apiService = retrofit.create(ApiService::class.java)
//
////    }
//
//}