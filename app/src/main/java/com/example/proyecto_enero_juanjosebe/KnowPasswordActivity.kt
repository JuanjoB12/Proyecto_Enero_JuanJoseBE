package com.example.proyecto_enero_juanjosebe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto_enero_juanjosebe.databinding.ActivityKnowPasswordBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
// Clase recuperar contraseña
class KnowPasswordActivity : AppCompatActivity() {
    // Variable binding
    lateinit var binding: ActivityKnowPasswordBinding
    // Método onCreate donde añadiremos la acciones correspondientes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKnowPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Asignacion de la accion
        binding.Brecuperarcontrasenia.setOnClickListener{
            sendPassword(binding.ETemailrecuperar.text.toString())
        }
    }

    // Metodo de enviar email
    private fun sendPassword(email:String){
        var firebaseAuth = Firebase.auth

        firebaseAuth.sendPasswordResetEmail(email)
                // Si se encuentra se envia el email infomando con un toast
            .addOnCompleteListener(){ task->
                if(task.isSuccessful){
                      Toast.makeText(this,"Se ha enviado el correo electrónico",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"No se ha podido enviar el correo electrónico",Toast.LENGTH_SHORT).show()

                }
            }
    }

}