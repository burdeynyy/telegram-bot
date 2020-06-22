package com.vistar.service;

import com.vistar.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service to work with clients.
 */

public interface ClientService {

    Page<Client> list(Pageable pageable);

    Optional<Client> findById(Long id);
}
