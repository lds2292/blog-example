package com.example.eventlistener

import com.example.member.Member

class SavedMemberEvent (
    member : Member
){
    val id : Int = member.id
    val name : String = member.name
    val email : String = member.email
}
