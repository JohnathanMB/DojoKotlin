package com.example.johnathanmonsalve.dojokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.johnathanmonsalve.dojokotlin.DataBase.Dbhelper
import com.example.johnathanmonsalve.dojokotlin.Models.Note
import kotlinx.android.synthetic.main.activity_new__note.*

class New_Note : AppCompatActivity() {

    private var database: Dbhelper?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new__note)

        guardar.setOnClickListener{
            val title = titulo.text.toString()
            val body = texto.text.toString()

            var note = Note(title, body)

            database = Dbhelper(this)
            database!!.insertNote(note)

            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)

        }

        salir.setOnClickListener{
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }

    }
}
