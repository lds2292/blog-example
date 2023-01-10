package com.example.eventlistener

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest{

    @Autowired
    lateinit var memberService: MemberService

    @Autowired
    lateinit var emailService: EmailService

    @Test
    fun test(){
        memberService.save("브라운", "brown@gmail.com")
    }

}