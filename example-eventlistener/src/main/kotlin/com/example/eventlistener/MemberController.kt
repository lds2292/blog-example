package com.example.eventlistener

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("member")
class MemberController(private val memberService: MemberService) {

    @GetMapping
    fun save() {
        memberService.save("브라운", "browngoo@gmail.com")
    }

}