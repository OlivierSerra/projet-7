package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurveService {
    List<CurvePoint> findAll();
    CurvePoint findById(Integer id);
    CurvePoint save(CurvePoint curvePoint);
    CurvePoint update(Integer id, CurvePoint curvePoint);
    void deleteById(Integer id);
}
