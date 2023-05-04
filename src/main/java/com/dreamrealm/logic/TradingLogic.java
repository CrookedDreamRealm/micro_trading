package com.dreamrealm.logic;

import com.dreamrealm.DTO.TradingDTO;
import com.dreamrealm.model.Trading;
import com.dreamrealm.repository.TradingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradingLogic {
    @Autowired
    TradingRepository tradingRep;
    public boolean createTrade(Trading trading){
        try{
            ModelMapper modelMapper = new ModelMapper();
            TradingDTO tradingDTO = modelMapper.map(trading, TradingDTO.class);
            tradingRep.save(tradingDTO);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public List<Trading> getAllTrades(){
        List<TradingDTO> tradingDTO = (List<TradingDTO>) tradingRep.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Trading> trades = tradingDTO.stream().map(trade -> modelMapper.map(trade, Trading.class)).collect(Collectors.toList());
        return trades;
    }

    public boolean editTrade(Trading trading){
        try{
            ModelMapper modelMapper = new ModelMapper();
            TradingDTO tradingDTO = modelMapper.map(trading, TradingDTO.class);
            TradingDTO oldItem = tradingRep.findItemById(tradingDTO.getId());
            TradingDTO newItem = tradingDTO;
            newItem.setId(oldItem.getId());
            tradingRep.save(newItem);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
