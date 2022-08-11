package com.example.cpexternalaccess

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextTextPersonName)
        meaning = findViewById(R.id.editTextTextPersonName2)

        cursor = contentResolver.query(ExternalContetnProvider.URI, arrayOf(ExternalContetnProvider.ID,
            ExternalContetnProvider.NAME, ExternalContetnProvider.MEANING),null,null,null)
            val CPClient = contentResolver.acquireContentProviderClient(ExternalContetnProvider.URI)

            Log.e(TAG,"${CPClient.toString()}  -- CP")
    }
    lateinit var name: EditText
    lateinit var meaning: EditText
    var cursor: Cursor? = null

    fun onClickInsert(view: View){
        val values = ContentValues()
        values.put("NAME", name.text.toString())
        values.put("MEANING", meaning.text.toString())
        contentResolver.insert(ExternalContetnProvider.URI, values)

    }

    fun updateOnClick(view: View){

    }
    fun onClickDelete(view: View){

    }
    fun onClickNext(view: View){
        if(cursor?.moveToNext()!!){
            name.setText(cursor!!.getString(1))
            meaning.setText(cursor!!.getString(2))

        }
    }
    fun onClickPrevious(view: View){
        if(cursor?.moveToPrevious()!!){
            name.setText(cursor!!.getString(1))
            meaning.setText(cursor!!.getString(2))
        }
    }
    fun onClickClear(view: View){
        name.setText("")
        meaning.setText("")
        cursor?.moveToPosition(-1)
        name.requestFocus()
    }

}