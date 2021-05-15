package cl.douc.aquaforms1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.douc.aquaforms1.model.Mensaje


@Database(entities = [Mensaje::class], version =  1)
abstract class MensajeDataBase:RoomDatabase() {

    abstract fun mensajeDao(): MensajeDao

    //SINGLETON - COLA DE A UNO
    companion object{
        @Volatile
        private  var INSTANCE: MensajeDataBase? = null

        fun getDatabase(context: Context): MensajeDataBase{
            if (INSTANCE == null)
            {
                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(context,
                        MensajeDataBase::class.java,
                        "mensaje.db"). build()
                }
            }
            return INSTANCE!!
        }
    }


}