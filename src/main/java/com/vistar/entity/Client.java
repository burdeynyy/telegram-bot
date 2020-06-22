package com.vistar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Client entity.
 */
@Getter
@Setter
@Entity
@Table(name = "client")
@ToString
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name = "client_seq_gen", sequenceName = "client_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "telegram_user")
    private Long telegramUserId;

    public Client(String name, Long telegramUserId) {
        this.name = name;
        this.telegramUserId = telegramUserId;
    }
}
