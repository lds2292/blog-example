package com.example.eventlistener

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("async")
@SpringBootTest
class MemberAsyncServiceTest{

    @Configuration
    @EnableAsync
    @Import(EventListenerApplication::class)
    class AsyncConfiguration {}

    @Autowired
    lateinit var memberService: MemberService

    @Autowired
    lateinit var memberJpaRepository: MemberJpaRepository

    @Autowired
    lateinit var emailJpaRepository: EmailJpaRepository


    @Test
    fun `Async를 사용한 이벤트 발행 테스트`(){
        memberService.save("브라운", "brown@gmail.com")

        assertEquals(1, memberJpaRepository.findAll().size)
        assertEquals(1, emailJpaRepository.findAll().size)
    }

    @Test
    fun `이벤트 수신하는 서비스에서 오류가 발생할 경우 수신쪽 데이터는 롤백된다`(){
        memberService.save("오류", "오류")
        assertEquals(1, memberJpaRepository.findAll().size)
        assertEquals(0, emailJpaRepository.findAll().size)
    }

}