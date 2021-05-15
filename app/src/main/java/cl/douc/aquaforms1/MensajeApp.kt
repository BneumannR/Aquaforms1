package cl.douc.aquaforms1

import android.app.Application
import cl.douc.aquaforms1.repositorio.MensajeRepository

class MensajeApp: Application() {

    companion object{
        lateinit var repo: MensajeRepository
    }

    override fun onCreate() {
        super.onCreate()
        repo = MensajeRepository(this.applicationContext)
    }
}