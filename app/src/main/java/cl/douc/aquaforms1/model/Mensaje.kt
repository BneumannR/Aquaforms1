package cl.douc.aquaforms1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mensaje_table")
class Mensaje(var contenido:String) {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0




}