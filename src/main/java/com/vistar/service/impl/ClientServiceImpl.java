package com.vistar.service.impl;

import com.vistar.entity.Client;
import com.vistar.repository.ClientRepository;
import com.vistar.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Page<Client> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }
}
