package com.example.a620.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import com.example.a620.databinding.LucrativeShortDramaBinding

class LucrativeShortDrama_First :Fragment() {
    private var _binding: LucrativeShortDramaBinding? = null
    private val binding get() = _binding!!

    // 加载布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LucrativeShortDramaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置模块的静态内容
        binding.hjdjModule1.tagName.text = "科幻"
        binding.hjdjModule2.tagName.text = "爱情"
        binding.hjdjModule3.tagName.text = "悬疑"

        //点击icon跳转到答题页面，显示不同的答题内容
        binding.hjdjModule1.icon.setOnClickListener {
            jumpToEarnGoldActivity("technology")
        }

        binding.hjdjModule2.icon.setOnClickListener {
            jumpToEarnGoldActivity("love")
        }

        binding.hjdjModule3.icon.setOnClickListener {
            jumpToEarnGoldActivity("suspense")
        }
    }

    private fun jumpToEarnGoldActivity(type: String) {
        val intent = Intent(requireContext(), EarnGoldDrama::class.java)
        intent.putExtra("question_type", type)
        startActivity(intent)
    }
}