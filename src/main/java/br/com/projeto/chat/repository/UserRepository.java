package br.com.projeto.chat.repository;

import br.com.projeto.chat.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}