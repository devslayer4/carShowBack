package com.web3.carShow.Service;

import com.web3.carShow.Model.Car;
import com.web3.carShow.Model.Message;
import com.web3.carShow.Repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;



    /*-- CREATE --*/

    public Message createMessage(Message message){
        try {
            messageRepository.createMessage(message);
            return message;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    /*-- READ --*/

    public List<Message> getAllMesssage(){
        try {
            return this.messageRepository.getAllMessage();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Message getMessageById(Long id) {
        try {
            return this.messageRepository.getMessageById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    public String deleteMessageById(Long id){
        try {
            messageRepository.deleteMessageById(id);
            return "Message with id = " + id + " are deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String deleteAllMessage() {
        try {
            messageRepository.deleteAllMessage();
            return "All message are deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
