package com.dreamrealm.DTO;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("trading")
public class TradingDTO {
    @Id
    private String id;

    private String messageId;
    private String offer;
    private String status;
}
