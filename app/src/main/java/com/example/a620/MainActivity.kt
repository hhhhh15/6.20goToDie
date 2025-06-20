package com.example.a620

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.a620.Adapter.PaperAdapter
import com.example.a620.databinding.ActivityMainBinding
import com.example.a620.Fragment.GoodProfitTheater_Third
import com.example.a620.Fragment.GuessGoodPlay_Second
import com.example.a620.Fragment.LucrativeShortDrama_First
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 设置 ViewBinding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 准备 Fragment 列表
        val fragments = listOf(
            LucrativeShortDrama_First(),
            GuessGoodPlay_Second(),
            GoodProfitTheater_Third()
        )

        // 设置适配器
        Log.d(TAG, "fragments.size = ${fragments.size}")
        val adapter = PaperAdapter(this, fragments)
        binding.viewPager.adapter = adapter
        Log.d(TAG, "adapter itemCount = ${adapter.itemCount}")


        //TabLayoutMediator 对应标签与页面
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // 设置每个 Tab 对应的标题
            val text = when (position) {
                0 -> "好赚短剧"
                1 -> "好剧踩踩啦"
                2 -> "好赚剧场"
                else -> "标签${position + 1}"
            }

            tab.text = text
            Log.d(TAG, "TabLayoutMediator: 绑定 tab position=$position, text=${tab.text}")
        }.attach()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

