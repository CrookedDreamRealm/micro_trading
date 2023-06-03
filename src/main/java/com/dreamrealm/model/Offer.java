package com.dreamrealm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Offer {
    private String userId;
    private String messageId;
    private String offer;
    private String status;
}
