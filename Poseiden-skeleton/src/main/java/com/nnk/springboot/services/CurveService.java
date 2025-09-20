package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurveService {
    List<CurvePoint> findAll();
    CurvePoint findById(Integer id);
    CurvePoint save(CurvePoint curvePoint);
    CurvePoint update(Integer id, CurvePoint curvePoint);
    void deleteById(Integer id);
}
