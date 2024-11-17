//package com.example.newsheadlines
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//
//interface ApiService {
//
//    //@GET("movielist.json")
//    @GET("top-headlines?country=us&category=business&apiKey=e46c2caff1134ba4859c25c1682726f2")
//    ///@GET("search?q=chatgpt")
//    suspend fun getMovies() :News
//
//    companion object {
//        var apiService: ApiService? = null
//        fun getInstance() : ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    // .baseUrl("https://howtodoandroid.com/apis/")
//                    .baseUrl("https://newsapi.org/v2/")
//                    //.baseUrl("https://podcast-episodes.p.rapidapi.com/")
//
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }
//
//}
// 2
//package com.example.newsheadlines
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//
//interface ApiService {
//
//    @GET("top-headlines?country=us&category=business&apiKey=e46c2caff1134ba4859c25c1682726f2")
//    suspend fun getMovies(): News
//
//    companion object {
//        var apiService: ApiService? = null
//        fun getInstance(): ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl("https://newsapi.org/v2/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }
//}
package com.example.newsheadlines

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getMovies(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String // API key as a parameter
    ): News

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}

