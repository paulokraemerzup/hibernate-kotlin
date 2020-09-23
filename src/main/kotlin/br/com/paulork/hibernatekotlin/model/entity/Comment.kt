package br.com.paulork.hibernatekotlin.model.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Comment(

    @Id
    @GeneratedValue
    var id: String? = null,

    val content: String,

    /**
     * Plugins e configurações no POM.XML para o Lazy funcionar
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    val article: Article,

    /**
     * Plugins e configurações no POM.XML para o Lazy funcionar
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    val author: Author
)