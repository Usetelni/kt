package service

import model.Message

interface MessageService {

     fun getById(id: String): Message
     fun getAllMessage():     List<Message>

}