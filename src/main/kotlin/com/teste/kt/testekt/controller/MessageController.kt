package com.teste.kt.testekt.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.teste.kt.testekt.response.MessageResponse
import com.teste.kt.testekt.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController {


    val service: MessageService

    @Autowired
    constructor(service: MessageService){
        this.service = service
    }

    @GetMapping
    fun index(): List<MessageResponse> {
        return listOf(
            MessageResponse("1","eu"),
            MessageResponse("2","te"),
            MessageResponse("3","amo"),
            MessageResponse("4","tai")
        )
    }

}