package com.vistar.repository;

import com.vistar.entity.Client;
import com.vistar.entity.TelegramMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for work with messages.
 */
@Repository
public interface MessageRepository extends JpaRepository<TelegramMessage, Long> {

    Page<TelegramMessage> findAllByClient(Client client, Pageable pageable);
}
