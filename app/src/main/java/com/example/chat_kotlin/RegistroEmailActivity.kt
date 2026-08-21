package com.example.chat_kotlin

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chat_kotlin.databinding.ActivityRegistroEmailBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroEmailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistroEmailBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere por favor")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.btnRegistrar.setOnClickListener {
            validarInformacion()




        }


    }


    private var nombres = ""
    private var email = ""
    private var password = ""
    private var r_password = ""

    private fun validarInformacion() {
        nombres = binding.etNombres.text.toString().trim()
        email = binding.etEmail.text.toString().trim()
        password = binding.etPassword.text.toString().trim()
        r_password = binding.etRPassword.text.toString().trim()

        if(nombres.isEmpty()){
            binding.etNombres.error = "Ingrese nombre"
            binding.etNombres.requestFocus()
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etEmail.error = "Correo invalido"
            binding.etEmail.requestFocus()
        }
        else if(email.isEmpty()){
            binding.etEmail.error = "Ingrese corroe"
            binding.etEmail.requestFocus()
        }

        else if(password.isEmpty()){
            binding.etPassword.error = "Ingrese contraseña"
            binding.etPassword.requestFocus()
        }
        else if(r_password.isEmpty()){
            binding.etRPassword.error = "Repita contraseña"
            binding.etRPassword.requestFocus()
        }
        else if(password != password){
            binding.etRPassword.error = "Las contraseñas no coinciden"
            binding.etRPassword.requestFocus()
        }
        else{
            registrarUsuario()
        }


    }

    private fun registrarUsuario() {

    }


}
