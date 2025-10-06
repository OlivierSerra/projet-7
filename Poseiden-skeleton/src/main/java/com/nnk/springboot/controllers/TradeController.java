package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import java.sql.Timestamp;
import java.time.LocalDate;

@Controller
@RequestMapping("/trade")
public class TradeController {
    // TODO: Inject Trade service
    private final TradeService tradeService;

    public TradeController(TradeService tradeService){
        this.tradeService =tradeService;
    }

    @GetMapping("/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
        model.addAttribute("trades", tradeService.findAll());
        return "trade/list";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("trade", new Trade());
            return "trade/add";
    }

    @PostMapping("/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        if (result.hasErrors()) {
            return "trade/add";
        }
        tradeService.save(trade);
        return "redirect:/trade/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        model.addAttribute("trade", tradeService.findById(id) );
        return "trade/update";
    }

    @PostMapping("/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
        if (result.hasErrors()) {                            // ✅ 2) renvoyer le formulaire si erreurs
            return "trade/update";
        }
        Trade e = tradeService.findById(id);
        e.setId(trade.getId());
        e.setAccount(trade.getAccount());
        e.setType(trade.getType());
        e.setBuyQuantity(trade.getBuyQuantity());
        e.setSellQuantity(trade.getSellQuantity());
        e.setBuyPrice(trade.getBuyPrice());
        e.setSellPrice(trade.getSellPrice());
        e.setBenchmark(trade.getBenchmark());
        e.setTradeDate(trade.getTradeDate());
        e.setSecurity(trade.getSecurity());
        e.setStatus(trade.getStatus());
        e.setTradeDate(trade.getTradeDate());
        e.setBook(trade.getBook());
        e.setCreationName(trade.getCreationName());
        e.setCreationDate(trade.getCreationDate());
        e.setRevisionName(trade.getRevisionName());
        e.setRevisionDate(trade.getRevisionDate());
        e.setDealName(trade.getDealName());;
        e.setDealType(trade.getDealType());
        e.setSourceListId(trade.getSourceListId());
        e.setSide(trade.getSide());
        tradeService.save(e);
        return "redirect:/trade/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
        tradeService.deleteById(id);
        return "redirect:/trade/list";
    }
}
