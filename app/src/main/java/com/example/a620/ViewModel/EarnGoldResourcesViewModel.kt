package com.example.a620.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.a620.Dao.BaikeQuestion
import com.example.a620.Dao.BaikeResponse
import com.example.a620.Repository.QuestionRepository
import com.example.a620.RetrofitClient
import kotlinx.coroutines.launch

class EarnGoldResourcesViewModel (application: Application): AndroidViewModel(application){
    private val repository = QuestionRepository()
    val apikey="e1a7eea1e4024410dd3a2cc7fbc0dfbf"
    val TAG="mutile-choice"
    private val _question= MutableLiveData<BaikeQuestion>()
    val question: LiveData<BaikeQuestion> = _question

    private var questionList: List<BaikeQuestion> = listOf()
    private var currentIndex = 0


    fun fetchData(type: String) {
        //调用协程
        viewModelScope.launch {
            try {
                val list = repository.fetchQuestions(type, apikey)
                Log.d(TAG, "看看: $list")
                if (list.isNotEmpty()) {
                    questionList = list
                    currentIndex = 0
                    _question.value = questionList[currentIndex]  // 显示第一题
                }
                Log.d(TAG, "fetchData success: ${_question.value}")
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching data: ${e.message}")
            }
        }
    }
    //修改此时list列表数据显示的数据
    fun goToNextQuestion() {
        if (currentIndex < questionList.size - 1) {
            currentIndex++
            _question.value = questionList[currentIndex]
        }
    }

    fun goToPreviousQuestion() {
        if (currentIndex > 0) {
            currentIndex--
            _question.value = questionList[currentIndex]
        }
    }
    fun verifyAnswer(userChoice: String): Boolean {
        return userChoice.equals(questionList[currentIndex].answer, ignoreCase = true)
    }

    }

