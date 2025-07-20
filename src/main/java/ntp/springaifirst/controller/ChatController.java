package ntp.springaifirst.controller;

import ntp.springaifirst.dto.BillItems;
import ntp.springaifirst.dto.ChatRequest;
import ntp.springaifirst.entity.MessageMemory;
import ntp.springaifirst.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody ChatRequest request) {
        return Map.of("response", chatService.chat(request));
    }

//    @PostMapping("/chat")
//    public List<FilmInto> chat(@RequestBody ChatRequest request) {
//       return chatService.chat(request);
//    }

//    @PostMapping("/chat")
//    public ExpensenInto chat(@RequestBody ChatRequest request) {
//        return chatService.chat(request);
//    }

//    @PostMapping("/chat")
//    public String chat(@RequestBody ChatRequest request) {
//        return chatService.chat(request);
//    }


//    @PostMapping("/chat-image")
//    String chatImage(@RequestParam("file") MultipartFile file,
//            @RequestParam("message") String message) {
//        return chatService.chatImage(file, message);
//    }

    @PostMapping("/chat-image")
    public List<BillItems> chatImage(@RequestParam("file") MultipartFile file,
                        @RequestParam("message") String message) {
        return chatService.chatImage(file, message);
    }

    @GetMapping("/history")
    public List<MessageMemory> history() {
        return chatService.history();
    }

    @GetMapping("/history/{id}")
    public List<MessageMemory> history(@PathVariable("id") String id) {
        return chatService.findHistoryById(id);
    }
}
