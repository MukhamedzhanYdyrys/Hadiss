package com.example.hadiss

import com.example.hadiss.model.allHadeest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitClass {
    private const val BASE_URL = "https://hadeethenc.com/api/v1/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val serviceApi: HadeethApi = retrofit.create(HadeethApi::class.java)
}

interface HadeethApi {
    @GET("hadeeths/list/?page=1&per_page=1000&category_id=4&language=en")
    suspend fun getAllHadeest(): allHadeest
}