package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val nome = intent.getStringExtra("name")

        val emailTextView: TextView = findViewById<TextView>(R.id.emailTextView)
        val nomeTextView: TextView = findViewById<TextView>(R.id.nameTextView)

        emailTextView.text = email
        nomeTextView.text = nome

        val signOutButton: Button = findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener{
            auth.signOut()
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}