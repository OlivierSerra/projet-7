package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repo;


    public RatingServiceImpl(RatingRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Rating> findAll() {
        return repo.findAll();
    }

    @Override
    public Rating findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException(" not found " + id));
    }

    @Override
    public Rating save(Rating rating) {
        return repo.save(rating);
    }

    @Override
    public Rating update(Integer id, Rating rating) {
        Rating e = findById(id);
        e.setId(rating.getId());
        e.setMoodysRating(rating.getMoodysRating());
        e.setSandPRating(rating.getSandPRating());
        e.setFitchRating(rating.getFitchRating());
        e.setOrderNumber(rating.getOrderNumber());
        return repo.save(e);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
