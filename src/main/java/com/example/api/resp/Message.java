package com.example.api.resp;

import lombok.Data;

@Data
public class Message {
    private String Text;

    public Message(String text) {
        Text = text;
    }
}
