package com.vistar.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

/**
 * Telegram API initializer.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramBotInitializer {

    private final TelegramBot telegramBot;

    @PostConstruct
    private void init() {
        log.debug("Initializing telegram bots API . . .");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiRequestException e) {
            throw new RuntimeException(e);
        }
        log.debug("Telegram bots API has been successfully initialized");
    }

}
