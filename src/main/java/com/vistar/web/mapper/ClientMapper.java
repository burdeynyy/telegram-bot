package com.vistar.web.mapper;

import com.vistar.entity.Client;
import com.vistar.web.dto.ClientDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link com.vistar.entity.Client}.
 */
@Mapper
public interface ClientMapper {
    ClientDto toDto(Client entity);

}
