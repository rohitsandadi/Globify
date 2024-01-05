package com.example.globifyp.Chat.Socket;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.globifyp.Chat.Model.Message;
import com.example.globifyp.Chat.Model.MessageType;
import com.example.globifyp.Translator.Translating;

@Service
@Slf4j
public class SocketService {

    @Autowired
    Translating translator;
    public void sendSocketMessage(String room, String eventName, SocketIOClient senderClient, String message) throws Exception {
        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                translator.textTranslator(message, "hi");
                client.sendEvent(eventName,
                        new Message(MessageType.SERVER, message));
            }
        }
    }
    /*public void saveMessage(SocketIOClient senderClient, Message message) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.CLIENT)
                .content(message.getContent())
                .room(message.getRoom())
                .username(message.getUsername())
                .build());
        sendSocketMessage(senderClient, storedMessage, message.getRoom());
    }

    public void saveInfoMessage(SocketIOClient senderClient, String message, String room) {
        Message storedMessage = messageService.saveMessage(Message.builder()
                .messageType(MessageType.SERVER)
                .content(message)
                .room(room)
                .build());
        sendSocketMessage(senderClient, storedMessage, room);
    }*/



}
