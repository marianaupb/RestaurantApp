package com.example.restaurantapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.restaurantapp.chefinfo.ChefInfo;
import com.example.restaurantapp.chefinfo.ChefInfoRepository;
import com.example.restaurantapp.recipe.Recipe;
import com.example.restaurantapp.recipe.RecipeRepository;
import com.example.restaurantapp.weeklyinfo.WeeklyInfo;
import com.example.restaurantapp.weeklyinfo.WeeklyInfoRepository;

@Controller
public class AdminController {
	
	@Autowired
	private ChefInfoRepository chefInfoRepository;
	
	@Autowired
	private WeeklyInfoRepository weeklyInfoRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@RequestMapping(value = "/admin")
	public String admin()	{
		return "admin";
	}
	
	@RequestMapping(value="/admin/chefInfo")
	public String chefInfo(Model model)	{
		model.addAttribute("chefInfo", new ChefInfo());
		return "adminChef";
	}
	
	@RequestMapping(value="/admin/chefInfo", method = RequestMethod.POST)
	public String saveChef(ChefInfo chefInfo)	{
		chefInfoRepository.save(chefInfo);
		return "redirect:../admin";
	}
	
	@RequestMapping(value="/admin/weeklyInfo")
	public String weeklyInfo(Model model) {
		model.addAttribute("weeklyInfo", new WeeklyInfo());
		model.addAttribute("chefInfos", chefInfoRepository.findAll());
		return "adminWeeklyInfo";
	}
	
	@RequestMapping(value="/admin/weeklyInfo", method = RequestMethod.POST)
	public String saveWeeklyInfo(WeeklyInfo weeklyInfo)	{
		weeklyInfoRepository.save(weeklyInfo);
		return "redirect:../admin";
	}
	
	@RequestMapping(value="/admin/recipe")
	public String recipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("weeklyInfos", weeklyInfoRepository.findAll());
		return "adminRecipe";
	}
	
	@RequestMapping(value="/admin/recipe", method = RequestMethod.POST)
	public String saveRecipe(Recipe recipe)	{
		recipeRepository.save(recipe);
		return "redirect:../admin";
	}
	
}
