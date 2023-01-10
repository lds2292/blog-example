package com.example.eventlistener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
@Profile("!async && !required")
class MemberDefaultEventHandler{

    private val logger : Logger = LoggerFactory.getLogger(this::class.java)

    @EventListener
    fun defaultEventListener(event : SavedMemberEvent){
        logger.info("defaultEventListener ---> {}", event)
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun transactionalEventListenerBeforeCommit(event : SavedMemberEvent){
        logger.info("TransactionPhase.BEFORE_COMMIT ---> {}", event)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun transactionalEventListenerAfterCommit(event : SavedMemberEvent){
        logger.info("TransactionPhase.AFTER_COMMIT ---> {}", event)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun transactionalEventListenerAfterRollback(event : SavedMemberEvent){
        logger.info("TransactionPhase.AFTER_ROLLBACK ---> {}", event)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun transactionalEventListenerAfterCompletion(event : SavedMemberEvent){
        logger.info("TransactionPhase.AFTER_COMPLETION ---> {}", event)
    }
}