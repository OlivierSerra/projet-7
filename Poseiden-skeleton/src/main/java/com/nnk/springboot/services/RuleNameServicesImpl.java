package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import jakarta.validation.constraints.NotBlank;
import com.nnk.springboot.services.RuleNameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameServicesImpl implements RuleNameService{

    public final RuleNameRepository repo ;

    public RuleNameServicesImpl(RuleNameRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<RuleName> findAll(){
        return repo.findAll();
    }

    @Override
    public RuleName findById(Integer id){
        return repo.findById(id).orElseThrow(()-> new IllegalArgumentException("RuleName not found" + id));
    }

    @Override
    public RuleName update(Integer id, RuleName ruleName){
        RuleName e = findById(id);
        e.setId(ruleName.getId());
        e.setName(ruleName.getName());
        e.setDescription(ruleName.getDescription());
        e.setJson(ruleName.getJson());
        e.setTemplate(ruleName.getTemplate());
        e.setSQLStr(ruleName.getSQLStr());
        e.setSQLPart(ruleName.getSQLPart());
        return repo.save(e);
    }

    @Override
    public RuleName save(RuleName ruleName) {
        return repo.save(ruleName);
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }
}
