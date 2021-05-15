package cl.douc.aquaforms1.repositorio

import android.content.Context
import androidx.lifecycle.LiveData
import cl.douc.aquaforms1.model.Mensaje
import cl.douc.aquaforms1.room.MensajeDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MensajeRepository(var  context: Context) {

    var mDB = MensajeDataBase.getDatabase(context)

    fun agregar(mensaje: Mensaje)
    {

            //implementar los otros metodos del mensajeDao aca
        CoroutineScope(IO).launch {
            mDB.mensajeDao().agregar(mensaje)
        }

    }

    fun listar(): LiveData<List<Mensaje>>
    {
        return mDB.mensajeDao().listar()
    }
}