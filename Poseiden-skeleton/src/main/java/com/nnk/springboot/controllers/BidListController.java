package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/bidList")
public class BidListController {
    // TODO: Inject Bid service
    private final BidListService bidListService;
    public BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    @GetMapping("/list")
    public String home(Model model) {
        // TODO: call service find all bids to show to the view
        model.addAttribute("bidLists",
                bidListService.findAll());
        return "bidList/list";
    }

    @GetMapping("/add")
    public String addBidForm(Model model) {
        model.addAttribute("bidList", new BidList());
        return "bidList/add";
    }

    @PostMapping("/validate")
    public String validate(@Valid BidList bid, BindingResult result,
                           Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        if(result.hasErrors()) {
            return "bidList/add";
        }
        bidListService.save(bid);
        return "redirect:/bidList/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        model.addAttribute("bidList", bidListService.findById(id));
        return "bidList/update";
    }

    @PostMapping("/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
        if (result.hasErrors()) return "bidList/update";
        BidList existing = bidListService.findById(id);
        existing.setBidListId(bidList.getBidListId());
        existing.setAccount(bidList.getAccount());
        existing.setType(bidList.getType());
        existing.setBidQuantity(bidList.getBidQuantity());
        bidListService.save(existing);
        return "redirect:/bidList/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        bidListService.deleteById(id);
        return "redirect:/bidList/list";
    }

}
