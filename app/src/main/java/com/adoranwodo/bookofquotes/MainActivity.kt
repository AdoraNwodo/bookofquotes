package com.adoranwodo.bookofquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.adoranwodo.bookofquotes.adapter.QuoteAdapter
import com.adoranwodo.bookofquotes.model.Quote
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        val quotesList = arrayListOf<Quote>()

        db.collection("quotes")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        quotesList.add(Quote(document.id, document["quote"].toString(), document["author"].toString()))
                    }
                    initRecyclerView(quotesList)
                } else {
                    Log.w("QUOTE_ERROR_TAG", "Error getting documents.", task.exception)
                }
            }
    }

    private fun initRecyclerView(quotesList: ArrayList<Quote>){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = QuoteAdapter(quotesList)
        }
    }
}
