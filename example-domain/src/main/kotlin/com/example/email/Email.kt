package com.example.email

import javax.persistence.*

@Entity
class Email(
    @Column(name = "member_id")
    val email : String,
    @Column(name = "message", length = 100)
    val message : String,
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0
}