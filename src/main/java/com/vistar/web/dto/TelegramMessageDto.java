package com.vistar.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * TelegramMessage dto.
 */
@Getter
@Setter
public class TelegramMessageDto {
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private Long chatId;

    private Long repliedMessage;

    private boolean botAnswer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime creationDate;
}
