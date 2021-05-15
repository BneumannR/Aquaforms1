package cl.douc.aquaforms1.room

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.douc.aquaforms1.model.Mensaje


@Dao
interface MensajeDao {

    @Insert
    suspend fun agregar(mensaje: Mensaje)


    @Delete                 //hay que implementar el suspend   en el update y delete
    fun eliminar(mensaje:Mensaje)


    @Update
    fun actualizar(mensaje: Mensaje)

    @Query("select id, contenido from mensaje_table order by contenido")
    fun listar():LiveData<List<Mensaje>>

    @Query("select id, contenido from mensaje_table where id = :id" )
    fun buscar(id:Int): LiveData<Mensaje>
}