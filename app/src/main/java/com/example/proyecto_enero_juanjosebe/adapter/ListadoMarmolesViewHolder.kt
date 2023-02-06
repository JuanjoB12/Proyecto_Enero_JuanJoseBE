package com.example.proyecto_enero_juanjosebe.adapter

import android.app.AlertDialog
import android.system.Os.bind
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.proyecto_enero_juanjosebe.databinding.DiseniorecyclerBinding

// Clase view holder donde se almacenan todos los contenidos que cogemos del adapter
class ListadoMarmolesViewHolder(view: View):RecyclerView.ViewHolder(view) {


    val binding = DiseniorecyclerBinding.bind(view)

    // Función donde asignamos nuestra variable contenido a los text que hemos creados en el diseniorecycler
    fun render (contenido:DatosMarmoles){
        // Text del nombre
        binding.TVNombre.text=contenido.Nombre

        // Text del Tipo
        binding.TVTipo.text=contenido.Tipo

        // Text del Color
        binding.TVColor.text=contenido.Color

        itemView.setOnClickListener{

        }
    }
}