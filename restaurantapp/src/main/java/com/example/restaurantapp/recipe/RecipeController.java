package com.example.restaurantapp.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@RequestMapping(value = "/recipe/{id}")
	public String getRecipe(@PathVariable("id") long id, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(id).get());
		return "recipe";
	}

}
