package com.example.etiquetafotoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.button.MaterialButton

class InstagramLinksDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_instagram_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBryan = view.findViewById<MaterialButton>(R.id.btnBryanInstagram)
        val btnLizbeth = view.findViewById<MaterialButton>(R.id.btnLizbethInstagram)

        btnBryan.setOnClickListener {
            openUrl(getString(R.string.instagram_bryan_url))
        }

        btnLizbeth.setOnClickListener {
            openUrl(getString(R.string.instagram_lizbeth_url))
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.setPackage("com.instagram.android")
        try {
            startActivity(intent)
        } catch (e: Exception) {
            intent.setPackage(null)
            startActivity(intent)
        }
    }

    override fun getTheme() = R.style.FullScreenDialogTheme
}
