package com.teste.kt.testekt.mapper.response

import com.teste.kt.testekt.model.Message
import com.teste.kt.testekt.response.MessageResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageResponseMapper {

    fun response(response:Message): MessageResponse{
       return  MessageResponse(response.id, response.message)
    }
}