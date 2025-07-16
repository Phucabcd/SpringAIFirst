package ntp.springaifirst.controller;

import ntp.springaifirst.dto.BillItems;
import ntp.springaifirst.dto.ChatRequest;
import ntp.springaifirst.dto.ExpensenInto;
import ntp.springaifirst.dto.FilmInto;
import ntp.springaifirst.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

//    @PostMapping("/chat")
//    public Map<String, String> chat(@RequestBody ChatRequest request) {
//        return Map.of("response", chatService.chat(request));
//    }

//    @PostMapping("/chat")
//    public List<FilmInto> chat(@RequestBody ChatRequest request) {
//       return chatService.chat(request);
//    }

    @PostMapping("/chat")
    public ExpensenInto chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }


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
}
