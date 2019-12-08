package com.example.restaurantapp;

import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restaurantapp.admin.User;
import com.example.restaurantapp.admin.UserRepository;
import com.example.restaurantapp.booking.Booking;
import com.example.restaurantapp.booking.BookingRepository;
import com.example.restaurantapp.chefinfo.ChefInfo;
import com.example.restaurantapp.chefinfo.ChefInfoRepository;
import com.example.restaurantapp.comments.Comment;
import com.example.restaurantapp.comments.CommentRepository;
import com.example.restaurantapp.recipe.Recipe;
import com.example.restaurantapp.recipe.RecipeRepository;
import com.example.restaurantapp.restaurantinfo.Restaurant;
import com.example.restaurantapp.restaurantinfo.RestaurantRepository;
import com.example.restaurantapp.weeklyinfo.WeeklyInfo;
import com.example.restaurantapp.weeklyinfo.WeeklyInfoRepository;

/**
 * @author Mariana Boueres
 */

@SpringBootApplication
public class RestaurantappApplication {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RestaurantappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestaurantappApplication.class, args);
		logger.info("It's working so :) ");
	}

	@Bean
	public CommandLineRunner demo(RestaurantRepository restaurantrepository) {
		return (args) -> {

			restaurantrepository.deleteAll();
			Restaurant restaurant = restaurantrepository.save(new Restaurant("Restaurant Unique", "Mariana Boueres",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit varius odio, a interdum "
							+ "mi luctus at. Crasvulputate, quam ut commodo sagittis, nulla neque semper est, non tempus lectus "
							+ "metus id neque.", 987653789, "dsdushd@nhd.com"));
/*
			User user1 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
*/
		};
	}

}
