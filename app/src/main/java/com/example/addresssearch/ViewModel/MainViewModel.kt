package com.example.addresssearch.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.addresssearch.Model.ApiClient
import com.example.addresssearch.Model.Network
import com.example.addresssearch.Model.ResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    val liveData = MutableLiveData<ResponseModel>()
     fun  getApi(text : String) : LiveData<ResponseModel> {
        val apiClient = Network.getInstance().create(ApiClient::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val res = apiClient.getAddress(text)
            liveData.postValue(res)
        }
        return liveData

    }
}

class MainViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}