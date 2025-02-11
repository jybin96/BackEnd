package team.waggly.backend.controller

import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller
import team.waggly.backend.dto.chat.ChatMessageRequestDto
import team.waggly.backend.security.jwt.JwtDecoder
import team.waggly.backend.service.ChatMessageService

@Controller
class ChatController(
        private val jwtDecoder: JwtDecoder,
        private val chatMessageService: ChatMessageService,
) {
    @MessageMapping("/chat/message")
    fun chatMessage(@Payload requestDto: ChatMessageRequestDto,
                    @Header("Authorization") token: String
    ) {
        var token = token
        token = token.substring(7)
        requestDto.sender = jwtDecoder.decodeUsername(token)
        chatMessageService.sendChatMessage(requestDto)
    }
}