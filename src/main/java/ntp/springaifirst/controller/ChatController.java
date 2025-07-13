package ntp.springaifirst.controller;

import ntp.springaifirst.dto.ChatRequest;
import ntp.springaifirst.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }

    @PostMapping("/chat-image")
    String chatImage(@RequestParam("file") MultipartFile file,
            @RequestParam("message") String message) {
        return chatService.chatImage(file, message);
    }
}
