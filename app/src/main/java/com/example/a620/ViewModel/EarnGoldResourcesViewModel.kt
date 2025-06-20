package com.example.a620.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a620.Dao.BaikeQuestion
import com.example.a620.Dao.BaikeResponse
import com.example.a620.RetrofitClient
import kotlinx.coroutines.launch

class EarnGoldResourcesViewModel (application: Application): AndroidViewModel(application){
    val apikey="e1a7eea1e4024410dd3a2cc7fbc0dfbf"
    val TAG="mutile-choice"
    private val _question= MutableLiveData<BaikeQuestion>()
    val question: LiveData<BaikeQuestion> = _question

    fun fetchData(type:String){
        //调用协程
        viewModelScope.launch {
            try {
                val response = when(type) {
                    "technology" -> RetrofitClient.apiService.getBaikeTiKu(apikey)
                    "love" -> RetrofitClient.apiService.getBaikeTiKu(apikey)
//                    "chinese" -> RetrofitClient.apiService.getChineseQuestions(apikey)
                    else -> RetrofitClient.apiService.getBaikeTiKu(apikey)
                }
                _question.value = response.result
                Log.d(TAG, "fetchData:$question ")
            }catch (e: Exception){
                Log.e("ViewModel", "Error fetching: ${e.message}")
            }
        }
    }

}