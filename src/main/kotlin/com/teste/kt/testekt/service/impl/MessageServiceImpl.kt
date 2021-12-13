package com.teste.kt.testekt.service.impl

import com.teste.kt.testekt.exceptions.BaseException
import com.teste.kt.testekt.mapper.request.MessageRequestMapper
import com.teste.kt.testekt.mapper.response.MessageResponseMapper
import com.teste.kt.testekt.model.Message
import com.teste.kt.testekt.repository.MessageRepository
import com.teste.kt.testekt.request.MessageRequest
import com.teste.kt.testekt.response.MessageResponse
import com.teste.kt.testekt.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl: MessageService{


    val repository: MessageRepository
    val requestMapper: MessageRequestMapper
    val responseMapper: MessageResponseMapper

    @Autowired
    constructor(repository: MessageRepository,
                requestMapper: MessageRequestMapper,
                responseMapper: MessageResponseMapper
    ){
        this.repository = repository
        this.requestMapper = requestMapper
        this.responseMapper = responseMapper
    }

    override fun getById(id: String): Message {
       return repository.findById(id).orElseThrow{
           BaseException()
       }
    }

    override fun getAllMessage(): List<Message> {
       return  repository.findAll().toList()

    }

    override fun createMessage(request: MessageRequest) {
        repository.save(requestMapper.requestToModel(request.message))
    }
}