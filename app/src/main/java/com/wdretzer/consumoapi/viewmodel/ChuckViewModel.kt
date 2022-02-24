package com.wdretzer.consumoapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wdretzer.consumoapi.repository.ChuckRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class ChuckViewModel(private val repository: ChuckRepository = ChuckRepository.instance) :
    ViewModel() {
    private val _error: MutableLiveData<Boolean> = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    private val _success: MutableLiveData<String> = MutableLiveData()
    val success: LiveData<String>
        get() = _success

    fun joke() = viewModelScope.launch(Dispatchers.Main) {
        repository
            .joke()
            .catch { _error.value = true }
            .collect {
                _success.value = "Deu td certo!!  -> ${it.piada}"
            }
    }
}