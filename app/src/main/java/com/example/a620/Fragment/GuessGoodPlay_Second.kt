package com.example.a620.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a620.databinding.GuessGoodPlayBinding

class GuessGoodPlay_Second:Fragment() {
    private var _binding: GuessGoodPlayBinding? = null
    private val binding get() = _binding!!

    // 加载布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GuessGoodPlayBinding.inflate(inflater, container, false)
        return binding.root
    }
}