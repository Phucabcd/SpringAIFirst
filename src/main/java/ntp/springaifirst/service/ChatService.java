package ntp.springaifirst.service;

import ntp.springaifirst.dto.BillItems;
import ntp.springaifirst.dto.ChatRequest;
import ntp.springaifirst.dto.ExpensenInto;
import ntp.springaifirst.dto.FilmInto;
import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ChatService {

//NOTE************************************************************
    //du lieu thuong dung .content();
    //du lieu theo thuong nhieu param dung .entity(ExpensenInto.class);
    //du lieu phuc tap nhu List dung .entity(new ParameterizedTypeReference<List<FilmInto>>() {});
//END************************************************************


    private final ChatClient chatClient;
    private final JdbcChatMemoryRepository chatMemoryRepository;

    //constructor
    public ChatService(ChatClient.Builder builder, JdbcChatMemoryRepository chatMemoryRepository) {
        this.chatMemoryRepository = chatMemoryRepository;

        ChatMemory chatMemory = MessageWindowChatMemory.builder()
                .chatMemoryRepository(chatMemoryRepository)
                .maxMessages(20)
                .build();

        chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

//    public String chat(ChatRequest request) {
//        SystemMessage systemMessage = new SystemMessage("Bạn là một trợ lí AI của Phuc Nguyen" +
//                "Bạn sẽ giải đáp thắc mắc cho nhà tuyển dụng muốn biết thêm về tôi");
//
//        UserMessage userMessage = new UserMessage(request.message());
//
//        Prompt prompt = new Prompt(systemMessage, userMessage);
//
//        return chatClient
//                .prompt(prompt)
//                .call()
//                .content();
//    }


    public String chat(ChatRequest request) {
        SystemMessage systemMessage = new SystemMessage("Bạn là một trợ lí AI của Phuc Nguyen" +
                "Bạn sẽ giải đáp thắc mắc cho nhà tuyển dụng muốn biết thêm về tôi");

        UserMessage userMessage = new UserMessage(request.message());

        Prompt prompt = new Prompt(systemMessage, userMessage);

        String converstationId = "001";

        return chatClient
                .prompt(prompt)
//                .user("Do I have license to code?")
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, converstationId))
                .call()
                .content();
    }

    //create for prompt
    ChatOptions chatOptions = ChatOptions.builder()
            .temperature(1D)
            .build();

    public List<BillItems> chatImage(MultipartFile file, String message) {
        Media media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType(file.getContentType()))
                .data(file.getResource())
                .build();

        return chatClient.prompt()
                .options(chatOptions)
                .system("Bạn là một nhân viên thu ngân")
                .user(promptUserSpec -> promptUserSpec.media(media)
                .text(message))
                .call()
                .entity(new ParameterizedTypeReference<List<BillItems>>() {});
    }
}
