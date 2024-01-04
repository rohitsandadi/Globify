package com.example.globifyp.Archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketTextController {

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody TextMessageDTO textMessageDTO){
        template.convertAndSend("/topic/chatMessage", textMessageDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @SendTo("/topic/chatMessage")
    public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO){
        return textMessageDTO;
    }



}
