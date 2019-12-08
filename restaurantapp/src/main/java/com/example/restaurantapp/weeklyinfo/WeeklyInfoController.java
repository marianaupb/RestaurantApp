package com.example.restaurantapp.weeklyinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restaurantapp.booking.BookingRepository;
import com.example.restaurantapp.chefinfo.ChefInfoRepository;
import com.example.restaurantapp.comments.CommentRepository;
import com.example.restaurantapp.recipe.RecipeRepository;

@Controller
public class WeeklyInfoController {

	@Autowired // it will take care that the repository can be included here
	private WeeklyInfoRepository weeklyInfoRepository;

	//display the main page with information related to the current week
	@RequestMapping(value = "/restaurant")
	public String weeklyInfo(Model model) {
		WeeklyInfo weeklyInfo = weeklyInfoRepository.findFirstByOrderByDateDesc();
		
		if (weeklyInfo != null)	{
			model.addAttribute("weeklyInfo", weeklyInfo);
			return "weeklyInfo";
		}
		return "weeklyInfoNoContent";
	}
	
	@RequestMapping(value = "/restaurant/{id}")
	public String weeklyInfoById(@PathVariable("id") long id, Model model) {
		model.addAttribute("weeklyInfo", weeklyInfoRepository.findById(id));
		return "weeklyInfo";
	}
	
	@RequestMapping(value = "/restaurant/{id}/next")
	public String nextWeeklyInfo(@PathVariable("id") long id, Model model) {
		WeeklyInfo currentWeek = weeklyInfoRepository.findById(id).get();
		model.addAttribute("weeklyInfo", 
				weeklyInfoRepository.findFirstByDateGreaterThanOrderByDateAsc(currentWeek.getDate()).orElse(currentWeek));
		return "weeklyInfo";
	}

	@RequestMapping(value = "/restaurant/{id}/previous")
	public String previousWeeklyInfo(@PathVariable("id") long id, Model model) {
		WeeklyInfo currentWeek = weeklyInfoRepository.findById(id).get();
		model.addAttribute("weeklyInfo", 
				weeklyInfoRepository.findFirstByDateLessThanOrderByDateDesc(currentWeek.getDate()).orElse(currentWeek));
		return "weeklyInfo";
	}
}
