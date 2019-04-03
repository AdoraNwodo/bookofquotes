package com.adoranwodo.bookofquotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adoranwodo.bookofquotes.R
import com.adoranwodo.bookofquotes.model.Quote

class QuoteAdapter(private val list: List<Quote>)
    : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuoteViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val movie: Quote = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size


    class QuoteViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.quote_layout, parent, false)) {
        private var mQuoteView: TextView? = null
        private var mAuthorView: TextView? = null


        init {
            mQuoteView = itemView.findViewById(R.id.text_view_quote)
            mAuthorView = itemView.findViewById(R.id.text_view_author)
        }

        fun bind(quote: Quote) {
            mQuoteView?.text = quote.quote
            mAuthorView?.text = quote.author
        }

    }

}