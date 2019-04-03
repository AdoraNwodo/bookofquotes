package com.adoranwodo.bookofquotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()

        db.collection("quotes")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("QUOTE_TAG", document.id + " => " + document.data)
                    }
                } else {
                    Log.w("QUOTE_ERROR_TAG", "Error getting documents.", task.exception)
                }
            }

    }
}
