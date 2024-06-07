package com.web3.carShow.Controller;


import com.web3.carShow.Model.Car;
import com.web3.carShow.Model.Message;
import com.web3.carShow.Service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {
    private MessageService messageService;

    /*-- GET REQUEST --*/

    /* Get the list of all messages */
    @GetMapping("/message")
    public List<Message> getAllMessages() {
        return this.messageService.getAllMesssage();
    }



    /*-- POST REQUEST --*/

    /* Create a new message */
    @PostMapping("/message")
    public Message createMessage(@RequestBody Message message) {
        return this.messageService.createMessage(message);
    }



    /*-- DELETE MAPING --*/

    /* Delete all message */
    @DeleteMapping("/message/all")
    public String deleteMessage() {
        return this.messageService.deleteAllMessage();
    }

    /* Delete one message by his id */
    @DeleteMapping("/message/{id}")
    public String deleteMessageById(@PathVariable Long id) {
        return this.messageService.deleteMessageById(id);
    }
}
