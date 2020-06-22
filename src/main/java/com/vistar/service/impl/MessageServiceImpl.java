package com.vistar.service.impl;

import com.vistar.entity.Client;
import com.vistar.entity.TelegramMessage;
import com.vistar.repository.MessageRepository;
import com.vistar.service.MessageService;
import com.vistar.service.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;
    private final TelegramBot bot;

    @Override
    public TelegramMessage createAndSend(Client client, TelegramMessage telegramMessage) {
        try {
            bot.execute(new SendMessage(telegramMessage.getChatId(), telegramMessage.getContent()));
            telegramMessage.setClient(client);
            telegramMessage.setBotAnswer(true);
            return repository.save(telegramMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<TelegramMessage> getMessages(Client client, Pageable pageable) {
        return repository.findAllByClient(client, pageable);
    }
}
