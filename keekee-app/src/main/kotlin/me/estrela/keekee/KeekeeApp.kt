package me.estrela.keekee

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.bind.annotation.CrossOrigin

@SpringBootApplication
@EnableScheduling
@CrossOrigin
class KeekeeApp

fun main(args: Array<String>) {
    SpringApplication.run(KeekeeApp::class.java, *args)
}