package com.example.proyecto_enero_juanjosebe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_enero_juanjosebe.R

// Clase donde se van a coger los datos (en este caso de firebase)
class ListadoMarmolesAdapter(val listaMarmoles:List<DatosMarmoles>):RecyclerView.Adapter<ListadoMarmolesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListadoMarmolesViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ListadoMarmolesViewHolder(layoutInflater.inflate(R.layout.diseniorecycler,parent,false))
    }

    // Método se crea una variable de tipo listamarmoles con su posicion3
    override fun onBindViewHolder(holder: ListadoMarmolesViewHolder, position: Int) {
        val item = listaMarmoles[position]
        holder.render(item)
    }

    // Método que se sobreescribe y devuelve el tamaño de la lista
    override fun getItemCount(): Int {
       return listaMarmoles.size
    }

}