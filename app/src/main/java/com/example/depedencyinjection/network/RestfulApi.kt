package com.example.depedencyinjection.network

import com.example.depedencyinjection.model.ResponseDataMakeupItem
import retrofit2.Call
import retrofit2.http.GET

 interface RestfulApi {

    @GET("api/v1/products.json")
    fun getAllMakeup() : Call<List<ResponseDataMakeupItem>>
}