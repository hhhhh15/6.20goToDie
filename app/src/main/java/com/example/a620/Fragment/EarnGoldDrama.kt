package com.example.a620.Fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.a620.ViewModel.EarnGoldResourcesViewModel
import com.example.a620.databinding.EarnGoldDramaBinding
import androidx.appcompat.app.AppCompatActivity


class EarnGoldDrama:AppCompatActivity() {
    private lateinit var binding: EarnGoldDramaBinding
    private lateinit var viewModel: EarnGoldResourcesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EarnGoldDramaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 获取传入的参数
        val questionType = intent.getStringExtra("question_type") ?: "default"

        // 初始化 ViewModel
        viewModel = ViewModelProvider(this)[EarnGoldResourcesViewModel::class.java]

        // 监听数据变化，更新 UI
        viewModel.question.observe(this) { data ->
            binding.titleTextView.text = data.title
            binding.optionAButton.text = "A. ${data.answerA}"
            binding.optionBButton.text = "B. ${data.answerB}"
            binding.optionCButton.text = "C. ${data.answerC}"
            binding.optionDButton.text = "D. ${data.answerD}"
            binding.answerTextView.text = "正确答案：${data.answer}"
        }
        binding.earnGoldNextQuestion.setOnClickListener {
            viewModel.goToNextQuestion()
        }
        // 根据传入类型调用对应接口或数据
        viewModel.fetchData(questionType)
    }

}