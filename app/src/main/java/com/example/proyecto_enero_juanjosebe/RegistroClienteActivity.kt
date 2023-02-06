package com.example.proyecto_enero_juanjosebe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto_enero_juanjosebe.databinding.ActivityRegistroClienteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegistroClienteActivity : AppCompatActivity() {
    lateinit var  binding: ActivityRegistroClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Accion al dar al boton de registrarsee
        binding.BTREGISTRARSE.setOnClickListener(){
            // Comprobacion de los campos
            if (binding.ETNOMBREAPELLIDOS.text.toString().isNotEmpty() && binding.ETCIUDAD.text.toString().isNotEmpty() && binding.ETCODIGOPOSTAL.text.toString().isNotEmpty() && binding.ETEMAIL.text.toString().isNotEmpty() && binding.ETCONTRASENA.text.toString().isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    // Asignamiento de los datos para iniciar sesion
                    binding.ETEMAIL.text.toString(),
                    binding.ETCONTRASENA.text.toString()
                ).addOnCompleteListener(){
                    // Si se ha registrado correctamente le llevamos a la pantalla de menu¨_principal
                    if(it.isSuccessful){
                        val intent = Intent(this,Menu_Principal::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"ERROR: No se ha creado el usuario, revisa los datos",Toast.LENGTH_SHORT).show()
                    }
                }

                }

            else{
                Toast.makeText(this,"Algún campo se encuentra vacía",Toast.LENGTH_SHORT).show()

            }

            }
        }
    }
