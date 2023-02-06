package com.example.proyecto_enero_juanjosebe

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import com.example.proyecto_enero_juanjosebe.databinding.FragmentAniadirProductosBinding
import com.example.proyecto_enero_juanjosebe.databinding.FragmentInfoActivityBinding


class InfoActivity : Fragment() {
    lateinit var  imagen: ImageButton
    private var binding: FragmentInfoActivityBinding? = null
    private val _binding get() = binding!!

    // Variable de tipo de foto donde se guardara la foto que hagamos con la camara del dispositivo
    val pickFoto = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val image = it.data?.extras?.get("data") as Bitmap
        binding?.IMAGEBUTTON?.setImageBitmap(image)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoActivityBinding.inflate(inflater,container,false)
        val views = _binding.root

        // Asigamos el image en buttomimage

        binding?.BTOMARFOTO?.setOnClickListener(){
            pickFoto.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
        return views
    }


}