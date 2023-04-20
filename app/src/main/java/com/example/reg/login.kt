package com.example.reg

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var password:EditText
    lateinit var Login:Button
    lateinit var Signup:Button

    lateinit var reg: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail = findViewById(R.id.mail_field)
        password = findViewById(R.id.Pass_field)
        Login = findViewById(R.id.btn_log)
        Signup = findViewById(R.id.btn_create)

        reg = openOrCreateDatabase("User Reg", Context.MODE_PRIVATE, null)



        Login.setOnClickListener {
            var email = mail.text.toString().trim()
            var pass = password.text.toString().trim()
            if (email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "cannot read empty field", Toast.LENGTH_SHORT).show()
            }else{
                val cursor = reg.rawQuery("SELECT * FROM users WHERE email=? AND password=?", arrayOf(email, pass))

                if (cursor != null && cursor.moveToFirst()) {
                    Toast.makeText(this, "successfully loged in", Toast.LENGTH_SHORT).show()
                    // user is authenticated, start a new activity
                    val intent = Intent(this, Dashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }

            }
        }
        Signup.setOnClickListener {
            var gotoreg = Intent(this, MainActivity::class.java)
            startActivity(gotoreg)
        }
    }
}