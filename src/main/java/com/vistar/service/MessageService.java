package com.vistar.service;

import com.vistar.entity.Client;
import com.vistar.entity.TelegramMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service to work with messages.
 */

public interface MessageService {

    TelegramMessage createAndSend(Client client, TelegramMessage telegramMessage);

    Page<TelegramMessage> getMessages(Client client, Pageable pageable);
}
