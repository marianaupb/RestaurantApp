package com.example.restaurantapp.restaurantinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@RequestMapping(value = "/restaurantinfo")
	public String info(Model model) {
		model.addAttribute("restaurant", restaurantRepository.findFirstBy()); //1L because is long
		return "restaurantinfo";
	}

}
