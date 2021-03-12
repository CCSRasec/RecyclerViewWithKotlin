package com.example.recyclerviewwithkotlin.model

data class Email(
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    val selected: Boolean = false
)

class EmailBuilder{
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build(): Email = Email(user, subject, preview, date, stared, unread, false)
}

fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

fun fakeEmails() : MutableList<Email> = mutableListOf(
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = false
        unread = true
    },

    email {
        user = "Youtube"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = true
        unread = false
    },

    email {
        user = "Google"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = false
        unread = true
    },

    email {
        user = "Vivo"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = false
        unread = false
    },

    email {
        user = "Energisa"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = true
        unread = true
    },

    email {
        user = "Orkut"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá amigo, você precisa ver esse site"
        date = "20 Jun"
        stared = false
        unread = false
    }

)