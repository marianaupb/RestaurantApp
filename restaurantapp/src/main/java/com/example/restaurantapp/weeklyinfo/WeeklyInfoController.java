package com.example.restaurantapp.weeklyinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeeklyInfoController {
	
	@Autowired
	private WeeklyInfoRepository weeklyRepository;
	
	@RequestMapping (value="/restaurant")
	public String WeeklyInfo(Model model)	{
		model.addAttribute("weeklyInfos", weeklyRepository.findAll());
		return "weeklyInfo";
	}
		

}
