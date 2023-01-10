package com.example.member

import javax.persistence.*

@Entity
class Member(
    @Column(name = "name", length = 35)
    val name : String,

    @Column(name = "email", length = 50)
    val email : String,

) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id : Int = 0
}
