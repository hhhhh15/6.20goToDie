package com.example.a620.Repository

import android.util.Log
import com.example.a620.Dao.BaikeQuestion
import com.example.a620.Dao.BaikeResponse
import com.example.a620.RetrofitClient

class QuestionRepository {
    private val api = RetrofitClient.apiService
    private val TAG="QuestionRepository"

    suspend fun fetchQuestions(type: String, apiKey: String): List<BaikeQuestion> {
        val response = when(type) {
            "technology" -> api.getBaikeTiKu(apiKey)
            "love" -> api.getBaikeTiKu(apiKey)
//            "chinese" -> api.getBaikeTiKu(apiKey)
            else -> api.getBaikeTiKu(apiKey)
        }
        Log.d(TAG, "fetchQuestions: 看看QuestionRepository有没有获取到数据$response")
        if (response.code == 200 && response.result.isNotEmpty()) {
            return response.result
        }
        return emptyList()
    }
}