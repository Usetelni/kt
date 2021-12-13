package com.teste.kt.testekt.service

import com.teste.kt.testekt.model.Message
import com.teste.kt.testekt.request.MessageRequest
import org.springframework.stereotype.Service
import java.util.*


interface MessageService {

     fun getById(id: String): Message
     fun getAllMessage():     List<Message>
     fun createMessage(message: MessageRequest)

}