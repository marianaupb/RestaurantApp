package com.example.restaurantapp.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;
import com.example.restaurantapp.weeklyinfo.WeeklyInfoRepository;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private WeeklyInfoRepository weeklyInfoRepository;
	
	//creating a new booking
	@RequestMapping(value = "/booking")
	public String booking (@RequestParam("idWeeklyInfo") long idWeeklyInfo,  Model model)	{ 
		//before I was sending an empty booking and now I'm creating related with correct weeklyId
		model.addAttribute("booking", new Booking());
		model.addAttribute("idWeeklyInfo", idWeeklyInfo);
		return "booking";
	}

	//saving the booking and returning to the main page
	@RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
	public String saveBooking (@RequestParam("idWeeklyInfo") long idWeeklyInfo, Booking booking)	{
		WeeklyInfo weeklyInfo = weeklyInfoRepository.findById(idWeeklyInfo).get();
		booking.setWeeklyInfo(weeklyInfo);
		bookingRepository.save(booking);
		return "redirect:restaurant";
	}
	
	

}
