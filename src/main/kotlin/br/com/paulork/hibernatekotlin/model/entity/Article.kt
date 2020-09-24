package br.com.paulork.hibernatekotlin.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Article(

    @Id
    @GeneratedValue
    var id: String? = null,

    val content: String
)
