package com.vistar.web.mapper;

import com.vistar.entity.TelegramMessage;
import com.vistar.web.dto.TelegramMessageDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link TelegramMessage}.
 */
@Mapper
public interface MessageMapper {
    TelegramMessageDto toDto(TelegramMessage entity);

    TelegramMessage fromDto(TelegramMessageDto dto);
}
