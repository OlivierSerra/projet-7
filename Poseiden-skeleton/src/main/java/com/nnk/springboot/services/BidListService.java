package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidListService {
    List<BidList> findAll();
    BidList findById(Integer id);
    BidList save(BidList bid);
    BidList update(Integer id, BidList bid);
    void deleteById(Integer id);
}
