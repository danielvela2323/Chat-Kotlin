package com.example.chat_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat_kotlin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser == null){
            irOpcionesLogin()
        }

        // Implementar boton par acceder
        // Implemetar activity para google
        // Ver documentacion en Google e investigar como implementar nuevos tipos de menus
        // con animaciones




        // Fragmento por defecto
        verFragmentoPerfil()

        binding.bottomNV.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item_perfil->{
                    //Visualizar el fragmento perfil
                    verFragmentoPerfil()
                    true
                }
                R.id.item_usuarios->{
                    // visualizar el fragmento usuarios
                    verFragmentoUsuarios()
                    true
                }
                R.id.item_chats ->{
                    // Visualizar el fragmento chats
                    verFragmentoChats()
                    true
                }else->{
                    false
                }
            }
        }
    }



    private fun irOpcionesLogin(){
        startActivity(Intent(applicationContext, OpcionesLoginActivity::class.java))
    }

    private fun verFragmentoPerfil(){
        binding.tvTitulo.text = "Perfil"

        val fragment = FragmentPerfil()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentoFL.id, fragment,"Fragment perfil")
        fragmentTransaction.commit()
    }

    private fun verFragmentoUsuarios(){
        binding.tvTitulo.text = "Usuarios"

        val fragment = FragmentUsuarios()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentoFL.id, fragment,"Fragment usuarios")
        fragmentTransaction.commit()
    }

    private fun verFragmentoChats(){
        binding.tvTitulo.text = "Chats"

        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(binding.fragmentoFL.id, fragment,"Fragment chats")
        fragmentTransaction.commit()
    }


}

