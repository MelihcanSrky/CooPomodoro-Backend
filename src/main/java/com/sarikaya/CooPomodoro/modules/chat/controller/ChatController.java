package com.sarikaya.CooPomodoro.modules.chat.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.chat.requests.CreateChatRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetChatResponse;
import com.sarikaya.CooPomodoro.modules.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class ChatController {
    private ChatService chatService;

    @PostMapping("/create")
    @TokenValidation
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> add(@RequestBody CreateChatRequest createChatRequest) {
        try {
            this.chatService.add(createChatRequest);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while add chat"));
        }
    }

    @GetMapping("/{chatUuid}")
    @TokenValidation
    public ResponseEntity<ApiResponse> getChat(@PathVariable String chatUuid) {
        try {
            GetChatResponse chatResponse = this.chatService.getChat(chatUuid);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), chatResponse, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while get chat" + e.getMessage()));
        }
    }
}
