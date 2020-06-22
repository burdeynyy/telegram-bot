package com.vistar.service;

import com.vistar.config.properties.ApplicationProperties;
import com.vistar.entity.Client;
import com.vistar.entity.TelegramMessage;
import com.vistar.repository.ClientRepository;
import com.vistar.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Objects;
import java.util.Optional;

/**
 * Telegram bot implementation.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final ClientRepository clientRepository;
    private final MessageRepository messageRepository;
    private final ApplicationProperties properties;

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Telegram bot received an update {}", update);
        final Message message = update.getMessage();
        if (Objects.nonNull(message) && message.hasText()) {
            final Client client = getOrCreateClientIfNotExists(message.getFrom());
            messageRepository.save(new TelegramMessage(client, message.getText(), message.getChatId()));
        }
    }

    private Client getOrCreateClientIfNotExists(User user) {
        final long userId = user.getId().longValue();
        final Optional<Client> optionalUser = clientRepository.findByTelegramUserId(userId);
        return optionalUser.orElseGet(() -> clientRepository.save(new Client(user.getFirstName(), userId)));
    }


    @Override
    public String getBotUsername() {
        return properties.getTelegramBotUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getTelegramBotKey();
    }
}
