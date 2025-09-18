package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListServiceImpl implements BidListService{
    private final BidListRepository repo;

    public BidListServiceImpl(BidListRepository repo) {
        this.repo = repo;
    }

    public List<BidList> findAll(){
        return repo.findAll();
    }

    public BidList findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Bid not found " + id));
    }

    public BidList save(BidList b){
        return repo.save(b);
    }

    public BidList update(Integer id, BidList bid){
        BidList e = findById(id);
        e.setAccount(e.getAccount());
        e.setType(e.getType());
        e.setBidQuantity(e.getBidQuantity());
        return repo.save(e);
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

}
