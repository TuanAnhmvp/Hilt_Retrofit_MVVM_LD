package com.example.hilt_retrofit_mvvm_ld

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilt_retrofit_mvvm_ld.network.RecyclerData
import com.example.hilt_retrofit_mvvm_ld.network.RetroRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {
    var liveDataList: MutableLiveData<List<RecyclerData>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadListOfData(){
        repository.makeApiCall("ny", liveDataList)
    }



}