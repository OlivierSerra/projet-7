package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    List<Rating> findAll();
    Rating findById(Integer id);
    Rating save(Rating rating);
    Rating update(Integer id, Rating rating);
    void deleteById(Integer id);
}
