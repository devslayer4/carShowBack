package com.web3.carShow.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class Message {
    Long id;
    String firstname;
    String lastname;
    String email;
    String message;

    public Message(Long id, String firstname, String lastname, String email, String message) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.message = message;
    }
}
