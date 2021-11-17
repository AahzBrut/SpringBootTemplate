package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.GreetingRequest
import com.example.springboottemplate.dto.response.GreetingResponse
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    fun sendMessage(@Header(name = "simpSessionId") sessionId: String, request: GreetingRequest) : GreetingResponse{
        return GreetingResponse("Hello, ${request.name}, your sessionId is $sessionId")
    }
}