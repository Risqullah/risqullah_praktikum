package com.example.Projek_iki

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Projek_iki.Home.HomeFragment
import com.example.Projek_iki.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
// Kondisi jika isLogin bernilai true
        //val isLogin = sharedPref.getBoolean("isLogin", false)
        //if (isLogin) {
        //    startActivity(Intent(this, MainActivity::class.java))
        //    finish()
        //    return
        //}
        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()

            //if (user.isBlank() || pass.isBlank()) {
            //    Log.d("Unsuccessful Input", "Username or Password is empty!")
            //    Toast.makeText(this, "Username or Password is empty!", Toast.LENGTH_LONG - 2).show()
            //} else {
            //    val intent = Intent(this, MainActivity::class.java)
            //    intent.putExtra("Username", user)
            //    intent.putExtra("Password", pass)
            //    Log.d("Successful Input", "Username: $user Password: $pass")
            //    if (binding.switchRememberMe.isChecked) {
            //        Toast.makeText(this, "We'll Remember You :]", Toast.LENGTH_LONG).show()
            //    }

            //    startActivity(intent)
            if (user.isNotEmpty() && user == pass) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", user)
                editor.apply()

                startActivity(Intent(this, BaseActivity::class.java))
                finish()

            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }
}