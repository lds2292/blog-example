package com.example.eventlistener

import com.example.email.Email
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class EmailService(
    private val emailJpaRepository: EmailJpaRepository
) {

    private val logger : Logger = LoggerFactory.getLogger(this::class.java)

    fun send(email : String, message : String) : Email {
        logger.info("EmailService.send called!")
        val savedEmail = Email(email, message)
        return emailJpaRepository.save(savedEmail)
    }
}