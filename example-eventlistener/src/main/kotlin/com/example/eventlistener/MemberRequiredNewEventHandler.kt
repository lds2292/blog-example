package com.example.eventlistener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Profile("required")
class MemberRequiredNewEventHandler(
    private val emailService: EmailService
) {

    private val logger : Logger = LoggerFactory.getLogger(this::class.java)

    @TransactionalEventListener
    fun handleMemberSave(event : SavedMemberEvent){
        emailService.send(event.email, "Welcome! ${event.name}")
    }
}