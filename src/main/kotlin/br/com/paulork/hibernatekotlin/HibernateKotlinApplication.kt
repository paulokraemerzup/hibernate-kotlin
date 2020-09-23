package br.com.paulork.hibernatekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HibernateKotlinApplication

fun main(args: Array<String>) {
	runApplication<HibernateKotlinApplication>(*args)
}
