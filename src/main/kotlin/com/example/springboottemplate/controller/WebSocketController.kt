package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.GreetingRequest
import com.example.springboottemplate.dto.response.GreetingResponse
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.user.SimpUserRegistry
import org.springframework.stereotype.Controller
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@Controller
class WebSocketController(
    val messageTemplate: SimpMessagingTemplate,
    val userRegistry: SimpUserRegistry
) {

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    fun sendMessage(@Header(name = "simpSessionId") sessionId: String, request: GreetingRequest): GreetingResponse {

        println("Users: ${userRegistry.users}")

        messageTemplate.convertAndSendToUser(
            sessionId,
            "/queue/notifications",
            GreetingResponse(message = "Message '${request.name}' sent")
        )
        return GreetingResponse("Hello, ${request.name}, your sessionId is $sessionId")
    }

    @EventListener(SessionConnectedEvent::class)
    fun handleSessionConnectedEvent(event: SessionConnectedEvent) {
        val sessionId = event.message.headers["simpSessionId"].toString()
        println("Session connected: $sessionId")
    }

    @EventListener(SessionDisconnectEvent::class)
    fun handleSessionDisconnectEvent(event: SessionDisconnectEvent) {
        println("Session disconnected: ${event.message.headers["simpSessionId"]}")
    }
}