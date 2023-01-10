package com.example.eventlistener

import com.example.member.Member
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberJpaRepository: MemberJpaRepository,
    private val publisher: ApplicationEventPublisher,
) {

    private val logger : Logger = LoggerFactory.getLogger(this::class.java)

    fun save(name : String, email: String) {
        val member = Member(name, email)
        val savedMember = memberJpaRepository.save(member)
        publisher.publishEvent(SavedMemberEvent(savedMember))
    }

    fun signup(name: String){
        val member = Member(name, "$name@gmail.com")
        logger.info("step 1")
        publisher.publishEvent(SavedMemberEvent(member))
        logger.info("step 2")
        logger.info("step 3")

        if (name == "오류") throw RuntimeException("에러")
    }
}