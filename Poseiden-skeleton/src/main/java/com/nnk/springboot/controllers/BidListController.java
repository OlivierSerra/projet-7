package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.time.LocalDate;


@Controller
@RequestMapping("/bidList")
public class BidListController {
    // TODO: Inject Bid service
    /**
     * injection d'un service et création d'un controller
     */
    private final BidListService bidListService;
    public BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    /**
     * affichage de toutes les BidList
     * @param model
     * @return List
     */
    @GetMapping("/list")
    public String home(Model model) {
        // TODO: call service find all bids to show to the view
        model.addAttribute("bidLists",
                bidListService.findAll());
        return "bidList/list";
    }

    /**
     * ajout de BidList
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String addBidForm(Model model) {
        model.addAttribute("bidList", new BidList());
        return "bidList/add";
    }

    /**
     * validation et enr de new BidList
     * @param bid
     * @param result
     * @param model
     * @return
     */
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

    /**
     * Affichage du formulaire de MAJ
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        model.addAttribute("bidList", bidListService.findById(id));
        return "bidList/update";
    }

    /**
     * MAJ
     * @param id
     * @param bidList
     * @param result
     * @param model
     * @return
     */
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
        existing.setAskQuantity(bidList.getAskQuantity());
        existing.setBid(bidList.getBid());
        existing.setAsk(bidList.getAsk());
        existing.setBenchmark(bidList.getBenchmark());
        existing.setBidListDate(bidList.getBidListDate());
        existing.setCommentary(bidList.getCommentary());
        existing.setSecurity(bidList.getSecurity());
        existing.setStatus(bidList.getStatus());
        existing.setTrader(bidList.getTrader());
        existing.setBook(bidList.getBook());
        existing.setCreationName(bidList.getCreationName());
        existing.setCreationDate(bidList.getCreationDate());
        existing.setRevisionName(bidList.getRevisionName());
        existing.setRevisionDate(bidList.getRevisionDate());
        existing.setDealName(bidList.getDealName());
        existing.setDealType(bidList.getDealType());
        existing.setSourceListId(bidList.getSourceListId());
        existing.setSide(bidList.getSide());
        bidListService.save(existing);
        return "redirect:/bidList/list";
    }

    /**
     * suppr de BidList
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        bidListService.deleteById(id);
        return "redirect:/bidList/list";
    }
}
