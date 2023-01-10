package com.example.eventlistener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener

@Component
@Profile("async")
class MemberAsyncEventHandler(
    private val emailService: EmailService
) {

    private val logger : Logger = LoggerFactory.getLogger(this::class.java)

    @Async
    @TransactionalEventListener
    fun handleMemberSave(event : SavedMemberEvent){
        emailService.send(event.email, "Welcome! ${event.name}")
    }
}