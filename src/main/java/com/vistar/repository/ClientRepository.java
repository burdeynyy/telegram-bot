package com.vistar.repository;

import com.vistar.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for work with clients.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByTelegramUserId(Long id);
}
