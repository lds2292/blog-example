package com.example.eventlistener

import com.example.email.Email
import org.springframework.data.jpa.repository.JpaRepository

interface EmailJpaRepository : JpaRepository<Email, Int>