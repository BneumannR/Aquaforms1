package cl.douc.aquaforms1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.douc.aquaforms1.MensajeApp
import cl.douc.aquaforms1.model.Mensaje
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var mensajes: LiveData<List<Mensaje>>? = null

    init {
        mensajes = MensajeApp.repo.listar()
    }

    fun onAgregarClicked(mensaje: Mensaje){
            MensajeApp.repo.agregar(mensaje)


    }

}