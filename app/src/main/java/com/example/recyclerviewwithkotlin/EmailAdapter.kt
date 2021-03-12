package com.example.recyclerviewwithkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithkotlin.model.Email
import kotlinx.android.synthetic.main.email_item.view.*

class EmailAdapter(private val emails: MutableList<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    inner class EmailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(email: Email) {
            with(email) {
                val hash = user.hashCode()
                itemView.txt_user.text = user.first().toString()
            }
        }
    }
}
