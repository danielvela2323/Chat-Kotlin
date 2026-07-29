package com.example.chat_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat_kotlin.databinding.ActivityMainBinding

//Queda pendiente cambiar el nombre de los fragments xml

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNV.setOnClickListener { item ->
            when(item.id){
                R.id.item_perfil->{
                    //Visualizar el fragmento perfil
                    true
                }
                R.id.item_usuarios->{
                    // visualizar
                    true
                }
                R.id.item_chats ->{
                    true
                }else->{
                    false
                }
            }
        }

    }
}

