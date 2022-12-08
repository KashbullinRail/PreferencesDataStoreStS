package com.example.preferencesdatastorests.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    val readFromDataStore = repository.readFromDataStore.asLiveData()

    fun saveToDataStore(myName: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveToDataStore(myName)
    }
}