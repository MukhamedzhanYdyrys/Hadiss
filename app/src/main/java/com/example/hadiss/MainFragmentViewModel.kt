package com.example.hadiss

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hadiss.model.allHadeest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {
    val list = MutableLiveData<allHadeest>()

    fun getAllHadeest(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                list.postValue(RetrofitClass.serviceApi.getAllHadeest())
            }catch (e : Exception){
                Log.d("ERROR", e.toString())
            }
        }
    }
}