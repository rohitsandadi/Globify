package com.example.globifyp.Chat.Model;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message extends BaseModel{

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    private String content;
    private String room;

    private String username;

    /*public Message() {
    }

    public Message(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }*/

}
