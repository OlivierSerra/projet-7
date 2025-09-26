package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;

import java.util.List;


public interface TradeService {

    //public final TradeService tradeservice;

    List<Trade> findAll();
    Trade findById(Integer id);
    Trade save(Trade trade);
    Trade update(Integer id, Trade trade);
    void deleteById(Integer id);
}
