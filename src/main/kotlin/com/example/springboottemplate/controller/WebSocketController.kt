package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.GreetingRequest
import com.example.springboottemplate.dto.response.GreetingResponse
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessageType
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class WebSocketController(
    val messageTemplate: SimpMessagingTemplate
) {

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    fun sendMessage(@Header(name = "simpSessionId") sessionId: String, request: GreetingRequest): GreetingResponse {

        messageTemplate.convertAndSendToUser(
            sessionId,
            "/queue/notifications",
            GreetingResponse(message = "Message '${request.name}' sent"),
            createHeaders(sessionId)
        )
        return GreetingResponse("Hello, ${request.name}, your sessionId is $sessionId")
    }

    fun createHeaders(sessionId: String): MessageHeaders {
        return SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE).also {
            it.sessionId = sessionId
            it.setLeaveMutable(true)
        }.messageHeaders
    }
}