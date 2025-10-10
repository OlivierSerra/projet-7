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

/**
 * Faire fonctionner la page évaluation
 */

@Controller
@RequestMapping("/rating")
public class RatingController {
    // TODO: Inject Rating service
    /**
     * injestion d'une instance d'avalutiaon et utilisation dans un contrsuteur
     */
    private final RatingService ratingService;

    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    /**
     * afficher les évaluations dans une liste
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
        model.addAttribute("ratings", ratingService.findAll());
        return "rating/list";
    }
/*
 @GetMapping("/add")
    public String addRatingFoam(Rating rating) {
        return "rating/add";
    }

    */

    /**
     * afficher la page d'ajout des évaluations
     * @param model
     * @return
     */
        @GetMapping("/add")
        public String addRatingForm(Model model) {
            model.addAttribute("rating", new Rating());
            return "rating/add";
        }

    /**
     * afficher la page de validation des éval
     * @param rating
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        if (result.hasErrors()){
        return "rating/add";
        }
        ratingService.save(rating);
        return "redirect:/rating/list";
    }

    /**
     * afficher la page de MAJ des évaluations
     * @param id
     * @param model
     * @return
     */


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        model.addAttribute("rating", ratingService.findById(id));
        return "rating/update";
    }

    /**
     * MAJ d'un eval existante
     * @param id
     * @param rating
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
        if (result.hasErrors()) return "rating/update";
        Rating existing = ratingService.findById(id);
        existing.setMoodysRating(rating.getMoodysRating());
        existing.setSandPRating(rating.getSandPRating());
        existing.setFitchRating(rating.getFitchRating());
        existing.setOrderNumber(rating.getOrderNumber());
        ratingService.save(existing);
        return "redirect:/rating/list";
    }

    /**
     * suppr des eval
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        ratingService.deleteById(id);
        return "redirect:/rating/list";
    }
}
