package com.dreamrealm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Trading {
    private String id;
    private String userId;
    private String messageId;
    private String offer;
    private String status;
}
