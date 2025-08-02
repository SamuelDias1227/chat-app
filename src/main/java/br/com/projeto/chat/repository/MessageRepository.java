package br.com.projeto.chat.repository;

import br.com.projeto.chat.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByGroupId(Long groupId);
    List<Message> findByReceiverIdAndSenderId(Long receiverId, Long senderId);
}