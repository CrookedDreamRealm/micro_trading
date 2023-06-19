package com.dreamrealm.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    private String userId;
    private String messageId;
    private String offer;
    private String status;
}
