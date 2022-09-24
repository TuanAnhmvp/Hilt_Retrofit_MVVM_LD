package com.example.hilt_retrofit_mvvm_ld.network


data class RecyclerList(val items: List<RecyclerData>)
data class RecyclerData(val name: String?, val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?)

