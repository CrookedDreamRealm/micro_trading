package com.dreamrealm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dreamrealm.DTO.TradingDTO;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TradingRepository extends MongoRepository<TradingDTO, String> {
    @Query("{id:'?0'}")
    TradingDTO findItemById(String id);

    @Query(value="{messageId:'?0'}", fields="{'offer' : 1, 'status' : 1}")
    List<TradingDTO> findAll(String messageId);

    @Query(value="{userId:'?0'}", fields="{'userId' : 1, 'offer' : 1, 'status' : 1}")
    List<TradingDTO> findAllByUserId(String messageId);
}
