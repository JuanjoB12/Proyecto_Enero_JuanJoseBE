package com.example.proyecto_enero_juanjosebe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_enero_juanjosebe.adapter.DatosMarmoles
import com.example.proyecto_enero_juanjosebe.adapter.ListadoMarmolesAdapter
import com.example.proyecto_enero_juanjosebe.databinding.FragmentAniadirProductosBinding
import com.google.firebase.firestore.FirebaseFirestore



class HomeRecycler : Fragment() {

    // Variable tipo recycler
    private var recycler: RecyclerView? =null


    // ArrayList de tipo DatosMarmoles(donde se guardan los marmoles)
    private var listaMarmoles= ArrayList<DatosMarmoles>()


    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {

      var views: View= inflater.inflate(R.layout.fragment_home_recycler,container,false)
        // Inicializar Lista
        listaMarmoles = ArrayList()
        recycler = views.findViewById(R.id.recyclerid)
        recycler?.layoutManager=LinearLayoutManager(context)

        // Llamada al método
        loaddates()

        recycler?.adapter= ListadoMarmolesAdapter(listaMarmoles)
        // Devolvemos el método
        return views
    }

    // Método donde se cargan los datos
   fun loaddates(){
       val db =FirebaseFirestore.getInstance()

        // Cogemos la coleccion donde queremos guardar los datos
       db.collection("Productos")
           .get()
               // Cargamos toda la colllection
           .addOnSuccessListener { load ->
               for(productos in load){
                   var producto = productos.toObject(DatosMarmoles::class.java)
                   listaMarmoles.add(producto)
               }
               var adapter = ListadoMarmolesAdapter(listaMarmoles)
               recycler?.adapter=adapter

           }
           .addOnFailureListener{
               Log.d("load,","Error al cargar")
           }
   }
}