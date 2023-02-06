package com.example.proyecto_enero_juanjosebe

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proyecto_enero_juanjosebe.databinding.FragmentAniadirProductosBinding
import com.google.firebase.firestore.FirebaseFirestore


class AniadirProductos : Fragment(R.layout.fragment_aniadir_productos) {


    private val db = FirebaseFirestore.getInstance()

    private var _binding: FragmentAniadirProductosBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAniadirProductosBinding.inflate(inflater,container,false)

        val views = binding.root

        binding.BIntroducir.setOnClickListener{
            crearProducto()
        }

     return views
    }

    // Función que añadirá los productos
    fun crearProducto(){
        // Comprobación de los campos para que no estén vacíos
        if(binding.ETNombreMarmol.text.isNotEmpty() && binding.ETTipoMarmol.text.isNotEmpty() && binding.ETColor.text.isNotEmpty()){
            db.collection("Productos")
                    // Añadimos a nuestra coleccion de atributos el valor que ha obtenido mediante los editext (APUNTE IMPORTANTE DEBEN ESTÁN ORDENADOS SEGÚN APAREZCAN EN LA BASES DE DATOS DE FIREBASE)
                .add(mapOf(
                    // Introducción del campo Color
                    "Color" to binding.ETColor.text.toString(),
                    // Introducción del campo Nombre
                    "Nombre" to binding.ETNombreMarmol.text.toString(),
                    // Introducción del campo Tipo
                    "Tipo" to binding.ETTipoMarmol.text.toString()
                ))
                .addOnSuccessListener { documento ->
                    Log.d(TAG,"Se ha añadido el mármol correctamente a la base de datos")
                }
            // Se han introducido los datos por lo tanto informamos al usuario de que se han introducido correctamente
                .addOnFailureListener{ documento ->
                    Log.d(TAG,"ERROR: No se ha podido introducir el mármol")
                }
        }
        // Si los campos están vacíos informamos al usuario de que no se han podido introducir
        else{
             // Toast.makeText(this ,"Falta por añadir algún campo",Toast.LENGTH_SHORT).show()
        }

    }

}
