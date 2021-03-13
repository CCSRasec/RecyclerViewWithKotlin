package com.example.recyclerviewwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithkotlin.model.email
import com.example.recyclerviewwithkotlin.model.fakeEmails
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


private lateinit var adapter: EmailAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fakeit.init()
        setContentView(R.layout.activity_main)

        adapter = EmailAdapter(fakeEmails())
        recycler_view_main.adapter = adapter
        recycler_view_main.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            addEmail()
            recycler_view_main.scrollToPosition(0)
        }
    }
    fun addEmail(){
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt","BR")).parse(
            Fakeit.dateTime().dateFormatter()
        )
        adapter.emails.add(0,
        email {
            stared = false
            unread = true
            user = Fakeit.name().firstName()
            subject = Fakeit.company().name()
            date = SimpleDateFormat("d MMM", Locale("pt","BR")).format(sdf)
            preview = mutableListOf<String>().apply {
                repeat(10){
                    add(Fakeit.lorem().words())
                }
            }.joinToString { " " }
        })
        adapter.notifyItemInserted(0)
    }
}