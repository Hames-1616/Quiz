package com.news.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.news.models_retro.topnewsresponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class newsmanager {
    private val _newsresponse = mutableStateOf(topnewsresponse())
    val newsresponse : State<topnewsresponse>
    @Composable get() = remember{_newsresponse}

    init {
        getarticles()
    }
    //as soon as app is ready async and with callback - enqueue
    private fun getarticles(){
        val service = Api.retrofitservice.gettoparticles("IN","586658c946b84cbfb8511ec1e1ecc96d")
        service.enqueue(object : Callback<topnewsresponse>
        {
            override fun onResponse(
                call: Call<topnewsresponse>,
                response: Response<topnewsresponse>
            ) {
                if(response.isSuccessful)
                {
                    //is the response is successful there would a body and we are forcing it
                    _newsresponse.value=response.body()!!
                    Log.d("news","${_newsresponse.value}")
                }
                else
                    Log.d("error","${response.body()}")

            }

            override fun onFailure(call: Call<topnewsresponse>, t: Throwable) {
                Log.d("error","${t.printStackTrace()}")
            }
        }
        )

    }
}