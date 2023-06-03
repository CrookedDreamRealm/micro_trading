package com.dreamrealm.DTO;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document("trading")
public class TradingDTO {
    @Id
    private String id;
    private String userId;
    private String messageId;
    private String offer;
    private String status;
}
