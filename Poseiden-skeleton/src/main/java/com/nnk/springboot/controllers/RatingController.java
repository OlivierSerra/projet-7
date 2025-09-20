package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class RatingController {
    // TODO: Inject Rating service
    private final RatingService service;

    public RatingController(RatingService service){
        this.service = service;
    }

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
        model.addAttribute("rating", service.findAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingFoam(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        if (result.hasErrors()){
        return "rating/add";
        }
        service.save(rating);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        model.addAttribute("id ", service.findById(id));
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
        Rating existing = service.findById(id);
        existing.setMoodysRating(existing.getMoodysRating());
        existing.setSandPrating(existing.getSandPrating());
        existing.setFitchRating(existing.getFitchRating());
        existing.setOrderNumber(existing.getOrderNumber());
        service.save(existing);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        service.deleteById(id);
        return "redirect:/rating/list";
    }
}
