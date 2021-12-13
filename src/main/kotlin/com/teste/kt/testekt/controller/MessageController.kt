package controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import response.MessageResponse

@RestController
@RequestMapping("/message")
class MessageController {

    @GetMapping
    fun index(): List<MessageResponse> {
       return ;
    }

}