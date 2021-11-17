package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.GreetingRequest
import com.example.springboottemplate.dto.response.GreetingResponse
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    fun sendMessage(request: GreetingRequest) : GreetingResponse{
        println("Received message: $request")
        Thread.sleep(1000)
        return GreetingResponse("Hello, ${request.name}")
    }
}