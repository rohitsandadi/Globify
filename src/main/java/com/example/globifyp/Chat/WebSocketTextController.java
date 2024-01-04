package com.example.globifyp.Chat;

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
    SimpMessagingTemplate myController;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody TextMessageDTO textMessageDTO){
        myController.convertAndSend("/message/message", textMessageDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @SendTo("/message/message")
    public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO){
        return textMessageDTO;
    }



}
