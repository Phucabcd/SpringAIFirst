package ntp.springaifirst.controller;

import ntp.springaifirst.dto.ChatRequest;
import ntp.springaifirst.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }
}
