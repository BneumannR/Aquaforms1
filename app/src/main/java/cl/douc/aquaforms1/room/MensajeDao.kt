package cl.douc.aquaforms1.room

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.douc.aquaforms1.model.Mensaje


@Dao
interface MensajeDao {

    @Insert
    suspend fun agregar(mensaje: Mensaje)


    @Delete
    fun eliminar(mensaje:Mensaje)


    @Update
    fun actualizar(mensaje: Mensaje)

    @Query("select id, contenido from mensaje_table")
    fun listar():LiveData<List<Mensaje>>

    @Query("select id, contenido from mensaje_table where id = :id" )
    fun buscar(id:Int): LiveData<Mensaje>
}