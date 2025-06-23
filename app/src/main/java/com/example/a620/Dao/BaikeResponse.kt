package com.example.a620.Dao

data class BaikeResponse (
    val code: Int,
    val msg: String,
    val result: List<BaikeQuestion>
)