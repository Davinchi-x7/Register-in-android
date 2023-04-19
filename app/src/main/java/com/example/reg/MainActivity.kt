package com.example.reg

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var Firstname:EditText
    lateinit var Secondname:EditText
    lateinit var Email:EditText
    lateinit var Password:EditText
    lateinit var Create:Button
    lateinit var login:Button

    lateinit var reg:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Firstname = findViewById(R.id.NamePlate)
        Secondname = findViewById(R.id.SecondName)
        Email = findViewById(R.id.Email_ad)
        Password = findViewById(R.id.Password)
        Create = findViewById(R.id.reg_btn)
        login = findViewById(R.id.login_b_t)


        login.setOnClickListener {
            val go_login = Intent(this, login::class.java)
            startActivity(go_login)
        }

        reg = openOrCreateDatabase("User Reg", Context.MODE_PRIVATE, null)
        reg.execSQL("CREATE TABLE IF NOT EXISTS registry(firstname VARCHAR, secondname VARCHAR, email VARCHAR, password VARCHAR)")

        Create.setOnClickListener {
            var Edt_firstname = Firstname.text.toString().trim()
            var Edt_secondname = Secondname.text.toString().trim()
            var Edt_email = Email.text.toString().trim()
            var Edt_password = Password.text.toString().trim()

            if (Edt_firstname.isEmpty() || Edt_secondname.isEmpty() || Edt_email.isEmpty() || Edt_password.isEmpty()){
                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }
            else{
                reg.execSQL("INSERT INTO registry VALUES('\"+Edt_firstname+\"','\"+Edt_secondname+\"','\"+Edt_email+\"','\"+Edt_password+\"')")
                Toast.makeText(this, "User created succesfully", Toast.LENGTH_SHORT).show()
                val redirect = Intent(this, login::class.java)
                startActivity(redirect)
            }


        }
    }
}