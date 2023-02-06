package com.example.proyecto_enero_juanjosebe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.proyecto_enero_juanjosebe.databinding.ActivityMenuPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var toogle: ActionBarDrawerToggle
private lateinit var binding: ActivityMenuPrincipalBinding

class Menu_Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Tipo toogle, binding
        toogle = ActionBarDrawerToggle(this,binding.drawerLayout ,R.string.open_drawer,R.string.close_drawer)
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {

            when(it.itemId){
                // Item house lleva a camara (PROVISIONALMENTE)
                R.id.ITEMHOUSE ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView,InfoActivity())

                        commit()

                    }
                }
                // Item añadir lleva a añadir marmoles (PROVISIONALMENTE)

                R.id.ITEMAÑADIR -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fragmentContainerView,AniadirProductos())
                        commit()
                    }
                }
                R.id.ITEMHOUSE -> {
                    supportFragmentManager.beginTransaction().apply {

                        replace(R.id.fragmentContainerView,AniadirProductos())
                        commit()
                    }
                }

                 // Item cerrar sesión cierra la sesión del usuario
                R.id.ITEMCERRARSESION->{
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this,MainActivity::class.java))
                }

            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }
    // Método que interno que gestiona las acciones de los item (DEVUELVE BOLEEANO)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }



}
