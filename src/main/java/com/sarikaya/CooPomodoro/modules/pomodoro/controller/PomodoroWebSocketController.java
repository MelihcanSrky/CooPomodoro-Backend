package com.sarikaya.CooPomodoro.modules.pomodoro.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PomodoroWebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        Thread.sleep(250);
        return "Hello from Spring Web Socket!";
    }
}
