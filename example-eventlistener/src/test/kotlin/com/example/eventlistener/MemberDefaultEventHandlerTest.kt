package com.example.eventlistener

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MemberDefaultEventHandlerTest {

    @Autowired
    lateinit var memberService: MemberService

    @Test
    fun `정상동작시 EventListener와 TransactionEventListener로그 확인`(){
        memberService.signup("라이언")
    }

    @Test
    fun `오류발생시 EventListener와 TransactionEventListener로그 확인`(){
        assertThrows<RuntimeException> {
            memberService.signup("오류")
        }
    }
}