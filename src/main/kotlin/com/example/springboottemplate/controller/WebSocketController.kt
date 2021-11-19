package com.example.springboottemplate.controller

import com.example.springboottemplate.dto.request.GreetingRequest
import com.example.springboottemplate.dto.response.GreetingResponse
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent

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
            GreetingResponse(message = "Message '${request.name}' sent")
        )
        return GreetingResponse("Hello, ${request.name}, your sessionId is $sessionId")
    }

    @EventListener(SessionConnectedEvent::class)
    fun onSessionConnectedEvent(event: SessionConnectedEvent) {
        val sessionId = event.message.headers["simpSessionId"].toString()
        println("Session connected: $sessionId")
    }

    @EventListener(SessionDisconnectEvent::class)
    fun onSessionDisconnectEvent(event: SessionDisconnectEvent) {
        println("Session disconnected: ${event.message.headers["simpSessionId"]}")
    }

    @EventListener(SessionSubscribeEvent::class)
    fun onSessionSubscribeEvent(event: SessionSubscribeEvent){
        val sessionId = event.message.headers["simpSessionId"].toString()
        val topic = event.message.headers["simpDestination"].toString()
        println("Session: $sessionId subscribed to topic: $topic")
    }

    @EventListener(SessionUnsubscribeEvent::class)
    fun onSessionUnsubscribeEvent(event: SessionUnsubscribeEvent){
        val sessionId = event.message.headers["simpSessionId"].toString()
        val topic = event.message.headers["simpDestination"].toString()
        println("Session: $sessionId unsubscribed from topic: $topic")
    }
}