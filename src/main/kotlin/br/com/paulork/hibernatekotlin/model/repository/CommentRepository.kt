package br.com.paulork.hibernatekotlin.model.repository

import br.com.paulork.hibernatekotlin.model.entity.Comment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : CrudRepository<Comment, String>