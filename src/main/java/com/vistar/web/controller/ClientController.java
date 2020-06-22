package com.vistar.web.controller;

import com.vistar.entity.Client;
import com.vistar.entity.TelegramMessage;
import com.vistar.exception.EntityNotFoundException;
import com.vistar.service.ClientService;
import com.vistar.service.MessageService;
import com.vistar.web.dto.ClientDto;
import com.vistar.web.dto.TelegramMessageDto;
import com.vistar.web.mapper.ClientMapper;
import com.vistar.web.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.vistar.config.RestConfiguration.BASE_PREFIX;

/**
 * REST API for clients.
 */
@RestController
@RequestMapping(BASE_PREFIX + "/clients")
@RequiredArgsConstructor
@Transactional
@PreAuthorize("hasRole('ADMIN')")
public class ClientController {

    private final ClientService service;
    private final MessageService messageService;
    private final ClientMapper mapper;
    private final MessageMapper messageMapper;

    @GetMapping
    public Page<ClientDto> list(@PageableDefault(sort = "name", direction = Sort.Direction.ASC, size = 20) Pageable pageable) {
        return service.list(pageable).map(mapper::toDto);
    }

    @GetMapping("/{id}/messages")
    public Page<TelegramMessageDto> getMessages(@PathVariable("id") Long id, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        Client client = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Client.class));
        return messageService.getMessages(client, pageable).map(messageMapper::toDto);
    }

    @PostMapping("/{id}/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public TelegramMessageDto create(@PathVariable("id") Long id, @Valid @RequestBody TelegramMessageDto messageDto) {
        Client client = service.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Client.class));
        TelegramMessage created = messageService.createAndSend(client, messageMapper.fromDto(messageDto));
        return messageMapper.toDto(created);
    }


}
