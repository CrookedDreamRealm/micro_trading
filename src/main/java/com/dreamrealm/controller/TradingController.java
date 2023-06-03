package com.dreamrealm.controller;

import com.dreamrealm.logic.TradingLogic;
import com.dreamrealm.model.Offer;
import com.dreamrealm.model.Trading;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/trading", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RestController
public class TradingController {
    private final RabbitTemplate rabbitTemplate;

    public TradingController (RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    TradingLogic tradingLogic;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessenger(@RequestBody Offer offer){
        log.info("Received request to create offer: {}", offer);
        rabbitTemplate.convertAndSend("", "q.offer", offer);
        return ResponseEntity.ok().body(offer);
    }

    @RequestMapping(value = "/addTrade", method = RequestMethod.POST)
    public ResponseEntity<?> addTrade(@Valid @RequestBody Trading trading){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Boolean response = tradingLogic.createTrade(trading);
        return ResponseEntity.ok()
                .body(response);
    }

    @RequestMapping(value = "/editTrade", method = RequestMethod.POST)
    public ResponseEntity<?> editTrade(@Valid @RequestBody Trading trading){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Boolean response = tradingLogic.editTrade(trading);
        return ResponseEntity.ok()
                .body(response);
    }

    @RequestMapping(value= "/getAllTrades", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTrades() {
        List<Trading> trades = tradingLogic.getAllTrades();
        return ResponseEntity.ok()
                .body(trades);
    }
}
