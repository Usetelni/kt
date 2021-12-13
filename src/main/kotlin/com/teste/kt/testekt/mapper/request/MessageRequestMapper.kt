package com.teste.kt.testekt.mapper.request

import com.teste.kt.testekt.model.Message
import com.teste.kt.testekt.request.MessageRequest
import org.springframework.stereotype.Component
import java.util.*

@Component
class MessageRequestMapper {

    fun requestToModel(request:String): Message{
        return  Message(UUID.randomUUID().toString(),request)
    }
}