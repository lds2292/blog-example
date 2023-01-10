package com.example.eventlistener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EntityScan(basePackages = ["com.example"])
class EventListenerApplication

fun main(args: Array<String>) {
    runApplication<EventListenerApplication>(*args)
}