package com.example.reg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
    }
}