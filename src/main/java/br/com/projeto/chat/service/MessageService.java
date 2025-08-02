package br.com.projeto.chat.service;

import br.com.projeto.chat.model.*;
import br.com.projeto.chat.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired private MessageRepository messageRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private ChatGroupRepository groupRepo;

    public Message sendMessage(Long senderId, Long receiverId, Long groupId, String content) {
        Message msg = new Message();
        msg.setSender(userRepo.findById(senderId).orElseThrow());
        msg.setContent(content);
        msg.setTimestamp(LocalDateTime.now());

        if (receiverId != null) {
            msg.setReceiver(userRepo.findById(receiverId).orElseThrow());
        }
        if (groupId != null) {
            msg.setGroup(groupRepo.findById(groupId).orElseThrow());
        }

        return messageRepo.save(msg);
    }

    public List<Message> getGroupMessages(Long groupId) {
        return messageRepo.findByGroupId(groupId);
    }

    public List<Message> getPrivateMessages(Long user1Id, Long user2Id) {
        return messageRepo.findByReceiverIdAndSenderId(user1Id, user2Id);
    }
}