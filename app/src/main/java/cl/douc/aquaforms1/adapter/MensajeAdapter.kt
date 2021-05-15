package cl.douc.aquaforms1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import cl.douc.aquaforms1.R
import cl.douc.aquaforms1.databinding.ItemLayoutBinding
import cl.douc.aquaforms1.model.Mensaje

class MensajeAdapter(): RecyclerView.Adapter<MensajeAdapter.MensajeHolder>() {

    var lista:List<Mensaje> =  ArrayList()

    class  MensajeHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        fun binData(mensaje: Mensaje)
        {
            val binding = ItemLayoutBinding.bind(view)
            with(binding)
            {
                lblMensaje.text = mensaje.contenido
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)   //hay que importar R
        return  MensajeHolder(v)
    }

    override fun onBindViewHolder(holder: MensajeHolder, position: Int) {
        holder.binData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setMensaje(mensajes: List<Mensaje>)
    {
        lista = mensajes
        notifyDataSetChanged()
    }
}