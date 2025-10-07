package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService {

    private final CurvePointRepository repo;

    public CurvePointServiceImpl(CurvePointRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CurvePoint> findAll(){
        return repo.findAll();
    }

    @Override
    public CurvePoint findById(Integer id){
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("CurvePoint not found " + id));
    }

    @Override
    public CurvePoint save(CurvePoint curvePoint){
        return repo.save(curvePoint);
    }

    @Override
    public CurvePoint update(Integer id, CurvePoint curvePoint){
        CurvePoint e = findById(id);
        e.setId(curvePoint.getId());
        e.setTerm(curvePoint.getTerm());
        e.setValue(curvePoint.getValue());
        e.setCreationDate(curvePoint.getCreationDate());
        e.setAsOfDate(curvePoint.getAsOfDate());
        return repo.save(e);
    }

    @Override
    public void deleteById(Integer id){
        repo.deleteById(id);
    };
}
