package com.sarikaya.CooPomodoro.modules.chat.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetMessageResponse;
import com.sarikaya.CooPomodoro.modules.chat.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/api/chat/message")
public class MessageController {
    private MessageService messageService;

    @GetMapping("/{chatUuid}")
    @TokenValidation
    public ResponseEntity<ApiResponse> getChatMessages(
            @PathVariable String chatUuid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        try {
            Page<GetMessageResponse> messages = this.messageService.getChatMessages(chatUuid, page, limit);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while get messages: " + e.getMessage()));
        }
    }
}
