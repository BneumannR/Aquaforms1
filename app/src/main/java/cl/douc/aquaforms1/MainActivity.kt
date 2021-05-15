 package cl.douc.aquaforms1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.douc.aquaforms1.adapter.MensajeAdapter
import cl.douc.aquaforms1.databinding.ActivityMainBinding
import cl.douc.aquaforms1.model.Mensaje
import cl.douc.aquaforms1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var  binding:ActivityMainBinding
    lateinit var model:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        val adapter = MensajeAdapter()
        with(binding)
        {
            rvLista.layoutManager = LinearLayoutManager(this@MainActivity)
            rvLista.adapter = adapter

            btnAgregar.setOnClickListener {

                val msg = txtMensaje.text.toString()
                if (msg.isNotEmpty()) {
                    val mensaje = Mensaje(msg)
                    model.onAgregarClicked(mensaje)
                    txtMensaje.text.clear()
                } else {
                    txtMensaje.error = "Debe ingresar un mensaje!!!"
                }
            }
        }

        model.mensajes!!.observe(this, Observer {
            adapter.setMensaje(it)
        })


    }
}