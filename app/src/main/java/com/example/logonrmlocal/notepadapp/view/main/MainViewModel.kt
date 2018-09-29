package com.example.logonrmlocal.notepadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notepadapp.model.Nota
import com.example.logonrmlocal.notepadapp.repository.NotaRepository

class MainViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun buscarTodos() {
        isLoading.value = true
        notaRepository
                .buscarTodos({
                    isLoading.value = false
                    notas.value = it
                }) {
                    isLoading.value = false
                    notas.value = arrayListOf()
                }

    }

}