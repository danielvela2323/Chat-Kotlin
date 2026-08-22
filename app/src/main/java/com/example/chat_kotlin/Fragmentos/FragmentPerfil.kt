package com.example.chat_kotlin.Fragmentos

import android.content.Intent
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chat_kotlin.OpcionesLoginActivity
import com.example.chat_kotlin.databinding.FragmentPerfilBinding
import com.google.firebase.auth.FirebaseAuth


class FragmentPerfil : Fragment() {

    // Comentario: En la importacion de Context se tuvo que importar de forma manual, ya que
    // el editor importaba otra clase Context proveniente de Firebase, pero es de Android OJO!!
    private lateinit var binding : FragmentPerfilBinding
    private lateinit var mContext : Context
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPerfilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnCerrarSesion.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(mContext, OpcionesLoginActivity::class.java))
            activity?.finishAffinity()
        }
    }


}
