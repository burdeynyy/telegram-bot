package com.vistar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * TelegramMessage entity.
 */
@Getter
@Setter
@Entity
@Table(name = "message")
@ToString
@NoArgsConstructor
public class TelegramMessage {
    @Id
    @SequenceGenerator(name = "message_seq_gen", sequenceName = "message_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "chat")
    private Long chatId;

    @Column(name = "in_reply_to")
    private Long repliedMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private Client client;

    @CreatedDate
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "is_bot_answer")
    private boolean botAnswer;

    public TelegramMessage(Client client, String content, Long chatId) {
        this.client = client;
        this.content = content;
        this.chatId = chatId;
    }
}
