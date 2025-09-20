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

    @Override
    public List<BidList> findAll(){
        return repo.findAll();
    }

    @Override
    public BidList findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Bid not found " + id));
    }

    @Override
    public BidList save(BidList b){
        return repo.save(b);
    }

    @Override
    public BidList update(Integer id, BidList bid){
        BidList e = findById(id);
        e.setAccount(bid.getAccount());
        e.setType(bid.getType());
        e.setBidQuantity(bid.getBidQuantity());
        return repo.save(e);
    }

    @Override
    public void deleteById(Integer id){
        repo.deleteById(id);
    }

}
