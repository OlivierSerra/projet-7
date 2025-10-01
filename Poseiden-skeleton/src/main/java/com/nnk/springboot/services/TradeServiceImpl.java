package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TradeServiceImpl implements TradeService{

    private final TradeRepository repo;

    public TradeServiceImpl(TradeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Trade> findAll(){
        return repo.findAll();
    }

    @Override
    public Trade findById(Integer id){
        return repo.findById(id).orElseThrow(()-> new IllegalArgumentException("not found" + id));
   }

    @Override
    public Trade save(Trade trade){
        return repo.save(trade);
    }

    @Override
    public Trade update(Integer id, Trade trade){
        Trade e = findById(id);
        e.setId(trade.getId());
        e.setAccount(trade.getAccount());
        e.setType(trade.getType());
        e.setBuyQuantity(trade.getBuyQuantity());
        return repo.save(e);
    }

    @Override
    public void deleteById(Integer id) {

    }

    public void delete(Integer id) {
            repo.deleteById(id);
    }

}
