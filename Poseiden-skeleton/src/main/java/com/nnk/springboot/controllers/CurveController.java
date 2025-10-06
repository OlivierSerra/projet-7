package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/curvePoint")
public class CurveController {
    // TODO: Inject Curve Point service

    private final CurvePointService curvePointService;

    public CurveController(CurvePointService curvePointService){
        this.curvePointService = curvePointService;
    }

    @GetMapping
        public String rootDirect(){
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/list")
    public String home(Model model)
    {
        var allCurves = curvePointService.findAll();
        // TODO: find all Curve Point, add to model**
        model.addAttribute("curvePoints", allCurves);
        return "curvePoint/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("curvePoint", new CurvePoint());
        return "curvePoint/add";
}
    @PostMapping("/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list**
        if (result.hasErrors()){
            return "curvePoint/add";
        }
        curvePointService.save(curvePoint);
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form**
        model.addAttribute("curvePoint", curvePointService.findById(id));
        return "curvePoint/update";
    }

    @PostMapping("/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        if (result.hasErrors()) return "/curvePoint/update";
        CurvePoint existing = curvePointService.findById(id);
        existing.setCurveId(curvePoint.getCurveId());
        existing.setTerm(curvePoint.getTerm());
        existing.setValue(curvePoint.getValue());
        existing.setCreationDate(curvePoint.getCreationDate());
        existing.setAsOfDate(curvePoint.getAsOfDate());
        curvePointService.save(existing);
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        curvePointService.deleteById(id);
        return "redirect:/curvePoint/list";
    }
}
