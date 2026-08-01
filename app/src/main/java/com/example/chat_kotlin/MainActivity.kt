package com.example.chat_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.chat_kotlin.Fragmentos.FragmentChats
import com.example.chat_kotlin.Fragmentos.FragmentPerfil
import com.example.chat_kotlin.Fragmentos.FragmentUsuarios
import com.example.chat_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragmento por defecto
        verFragmentoPerfil()

        binding.bottomNV.setOnClickListener { item ->
            when(item.id){
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

    private fun verFragmentoPerfil(){
        binding.tvTitulo.text = "Pefil"

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

