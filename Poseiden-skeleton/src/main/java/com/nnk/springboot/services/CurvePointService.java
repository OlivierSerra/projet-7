package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurvePointService {
    List<CurvePoint> findAll();
    CurvePoint findById(Integer id);
    CurvePoint save(CurvePoint curvePoint);
    CurvePoint update(Integer id, CurvePoint curvePoint);
    void deleteById(Integer id);
}
