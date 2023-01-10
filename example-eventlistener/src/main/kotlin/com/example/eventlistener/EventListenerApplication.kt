package com.example.eventlistener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EntityScan(basePackages = ["com.example"])
@EnableAsync
class EventListenerApplication

fun main(args: Array<String>) {
    runApplication<EventListenerApplication>(*args)
}