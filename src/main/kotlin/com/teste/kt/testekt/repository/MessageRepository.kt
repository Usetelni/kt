package com.teste.kt.testekt.repository

import com.teste.kt.testekt.model.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository: CrudRepository<Message, String> {
}