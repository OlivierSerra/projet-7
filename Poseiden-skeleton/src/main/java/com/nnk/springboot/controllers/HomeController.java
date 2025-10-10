package com.nnk.springboot.controllers;

import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.BidListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nnk.springboot.services.BidListServiceImpl;

/**
 * utile pour afficher le bidListService
 */
@Controller
public class HomeController
{

	private final BidListService bidListService;

	public HomeController(BidListService bidListService) {
		this.bidListService = bidListService;
	}

	@RequestMapping("/")
	public String home(Model model)
	{
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{
		return "redirect:/admin/home";
	}

}
