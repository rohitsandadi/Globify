package com.example.globifyp.Chat.Controller;

import com.example.globifyp.Chat.Model.Message;
import com.example.globifyp.Chat.Model.MessageType;
import com.example.globifyp.Chat.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @CrossOrigin
    @GetMapping("/{room}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String room) {
        List<Message> l = new ArrayList<>();
        Message m = new Message();
        m.setMessageType(MessageType.CLIENT);
        m.setRoom("a");
        m.setContent("dumb");
        l.add(m);
        return ResponseEntity.ok(l);
                //ResponseEntity.ok(messageService.getMessages(room));
    }


}
