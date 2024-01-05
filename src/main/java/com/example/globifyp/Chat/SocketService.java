package com.example.globifyp.Chat;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.globifyp.Chat.Message;
import com.example.globifyp.Chat.MessageType;

@Service
@Slf4j
public class SocketService {
    public void sendMessage(String room,String eventName, SocketIOClient senderClient, String message) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName,
                        new Message(MessageType.SERVER, message));
            }
        }
    }
}
