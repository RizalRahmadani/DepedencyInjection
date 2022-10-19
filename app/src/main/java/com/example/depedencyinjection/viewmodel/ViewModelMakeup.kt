package com.example.depedencyinjection.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.depedencyinjection.model.ResponseDataMakeupItem
import com.example.depedencyinjection.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMakeup @Inject constructor(var api : RestfulApi) : ViewModel(){

    lateinit var liveDataMakeup: MutableLiveData<List<ResponseDataMakeupItem>>


    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getliveDataMakeup() : MutableLiveData<List<ResponseDataMakeupItem>> {
        return  liveDataMakeup
    }

    fun callApiMakeup(){
        api.getAllMakeup().enqueue(object : Callback<List<ResponseDataMakeupItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataMakeupItem>>,
                response: Response<List<ResponseDataMakeupItem>>
            ) {
                if (response.isSuccessful){
                    liveDataMakeup.postValue(response.body())
                }else{
                    liveDataMakeup.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataMakeupItem>>, t: Throwable) {
                liveDataMakeup.postValue(null)
            }

        })
    }

}