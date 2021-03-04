package com.sk.kafka.producer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class MessageObject implements Serializable {

    static final long serialVersionUID = -687991492884005033L;

    private String identifier;
    private String action;
}
