package br.com.projeto.chat.controller;

import br.com.projeto.chat.model.Message;
import br.com.projeto.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
    @Autowired private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestParam Long senderId,
                                @RequestParam(required = false) Long receiverId,
                                @RequestParam(required = false) Long groupId,
                                @RequestParam String content) {
        return messageService.sendMessage(senderId, receiverId, groupId, content);
    }

    @GetMapping("/group/{groupId}")
    public List<Message> getGroupMessages(@PathVariable Long groupId) {
        return messageService.getGroupMessages(groupId);
    }

    @GetMapping("/private")
    public List<Message> getPrivateMessages(@RequestParam Long user1,
                                            @RequestParam Long user2) {
        return messageService.getPrivateMessages(user1, user2);
    }
}
