package br.com.paulork.hibernatekotlin.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Author(

    @Id
    @GeneratedValue
    var id: String? = null,

    val name: String
)