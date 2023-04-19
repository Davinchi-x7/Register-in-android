package com.example.reg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var password:EditText
    lateinit var login:Button
    lateinit var Signup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail = findViewById(R.id.mail_field)
        password = findViewById(R.id.Pass_field)
        login = findViewById(R.id.btn_log)
        Signup = findViewById(R.id.btn_create)

        login.setOnClickListener {
            var email = mail.text.toString().trim()
            var pass = password.text.toString().trim()
            if (email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "cannot read empty field", Toast.LENGTH_SHORT).show()
            }else{

            }
        }
        Signup.setOnClickListener {
            var gotoreg = Intent(this, MainActivity::class.java)
            startActivity(gotoreg)
        }
    }
}