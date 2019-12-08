package com.example.restaurantapp.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;
import com.example.restaurantapp.weeklyinfo.WeeklyInfoRepository;

@Controller
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private WeeklyInfoRepository weeklyInfoRepository;
	
	//creating a new comment
	@RequestMapping(value="/comment")
	public String comment (@RequestParam("idWeeklyInfo") long idWeeklyInfo, Model model)	{
		model.addAttribute("comment", new Comment());
		model.addAttribute("idWeeklyInfo", idWeeklyInfo);
		return "comment";
	}
	
	@RequestMapping(value="/saveComment", method=RequestMethod.POST)
	public String saveComment(@RequestParam("idWeeklyInfo") long idWeeklyInfo, Comment comment)	{
		WeeklyInfo weeklyInfo = weeklyInfoRepository.findById(idWeeklyInfo).get();
		comment.setWeeklyInfo(weeklyInfo);
		commentRepository.save(comment);
		return "redirect:restaurant";
	}

}
