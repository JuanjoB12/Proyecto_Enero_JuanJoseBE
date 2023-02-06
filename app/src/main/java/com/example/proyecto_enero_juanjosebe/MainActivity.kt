package com.example.proyecto_enero_juanjosebe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.proyecto_enero_juanjosebe.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Si le damos al boton de inicios hará las comprobaciones correspondientes y nos dará acceso a la aplicación
       binding.BTINICIARSESION.setOnClickListener{
            iniciodeSesion()
        }
        // Si le damos boton registrar nos lleva al layout de RegistrarCliente (para que el cliente se registre)
        binding.BREGISTRAR.setOnClickListener(){
            registrarCliente()
        }
        // Si le damos al texto de olvidar contraseña nos llevara al layout de olvidarcontraseña para poder restablecerla
        binding.TVOlvidarContrasena.setOnClickListener(){
            recordarContrasenia()

        }
        val imagen = binding.imageView
        registerForContextMenu(imagen)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual,menu)
        if (menu != null) {
            menu.setHeaderTitle("Menu")
        }
    }
    // Metodo segun opciones
    override fun onContextItemSelected(item: MenuItem):Boolean {
        return when (item.itemId){

            //Opcion descargar
            R.id.descargar -> {
                Toast.makeText(this, "Opción descargar",Toast.LENGTH_SHORT).show()
                true
            }
            //Opcion compartir
            R.id.compartir -> {
                Toast.makeText(this, "Opción compartir",Toast.LENGTH_SHORT).show()
                true
            }
            //Opcion copiar
            R.id.copiar -> {
                Toast.makeText(this, "Opción copiar",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)}

    }
    // Función donde se hará el inicio de sesión
    private fun iniciodeSesion(){
        // Comprobación de los campos
        if (binding.ETEMAIL.text.toString().isNotEmpty() && binding.ETCONTRASENA.text.toString().isNotEmpty()){
            // Creamos una nueva instancia recogiendo el email y password y lo asignamos a los EDITEXTS CORRESPONDIENTES
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                // Campo del email
                binding.ETEMAIL.text.toString(),
                // Campo de la contraseña
                binding.ETCONTRASENA.text.toString()

            )
                // Añadimos si el inicio de sesión es válido o erroneo
                .addOnCompleteListener{
                    // Si el usuario es correcto y llamamos a nuestra clase principal
                    if(it.isSuccessful){
                        val intent = Intent(this, Menu_Principal::class.java)
                        startActivity(intent)
                     // Si no está el usuario o contraseña falla, informamos al usuario
                    }else{

                        Toast.makeText(this,"Correo electrónico o contraseña no válidos",Toast.LENGTH_SHORT).show()

                    }

                }
        }else{
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()

        }
    }
    // Función que llevará al usuario a la página para que se registre
    private fun registrarCliente(){
        startActivity(Intent(this,RegistroClienteActivity::class.java))

    }
    // Función donde llevará al usuario en caso de que quiera restablecer la contraseña
    private fun recordarContrasenia(){
        startActivity(Intent(this,KnowPasswordActivity::class.java))
    }
}