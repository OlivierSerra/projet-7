package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface RuleNameService {
    List<RuleName> findAll();
    RuleName findById(Integer id);
    RuleName update(Integer id, RuleName ruleName);
    RuleName save(RuleName ruleName);
    void deleteById(Integer id);
}
