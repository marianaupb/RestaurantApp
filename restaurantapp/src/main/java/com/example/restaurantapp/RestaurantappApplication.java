package com.example.restaurantapp;

import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restaurantapp.chefinfo.ChefInfo;
import com.example.restaurantapp.chefinfo.ChefInfoRepository;
import com.example.restaurantapp.recipe.Recipe;
import com.example.restaurantapp.recipe.RecipeRepository;
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

	// Leaving like this for first test
	// I created the "deleteAll" to start again everytime, but i'm gonna change it
	// later
	@Bean
	public CommandLineRunner demo(ChefInfoRepository chefrepository, RecipeRepository reciperepository,
			WeeklyInfoRepository weeklyinforepository) {
		return (args) -> {
			chefrepository.deleteAll();
			ChefInfo chefinfo = chefrepository.save(new ChefInfo("Inacio Boueres",
					"Quisque non mauris et felis facilisis consectetur. Donec eget purus tempus, viverra purus non, venenatis ante. Nam condimentum sapien sed sollicitudin eleifend. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed suscipit dignissim dui, ut efficitur leo iaculis non. Sed vel augue in ligula posuere dictum. Ut at mauris lobortis, sollicitudin lectus vel, consequat ipsum."));

			weeklyinforepository.deleteAll();
			WeeklyInfo weeklyinfo = weeklyinforepository.save(new WeeklyInfo(new Date(),
					"Quisque non mauris et felis facilisis consectetur. Donec eget purus tempus, viverra purus non, venenatis ante. Nam condimentum sapien sed sollicitudin eleifend. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed suscipit dignissim dui, ut efficitur leo iaculis non. Sed vel augue in ligula posuere dictum. Ut at mauris lobortis, sollicitudin lectus vel, consequat ipsum.",
					chefinfo));

			reciperepository.deleteAll();
			Recipe recipe = reciperepository.save(new Recipe(new Date(), "Inacio Boueres", "svdsbfibf",
					"ksjnbhs8 9 uhfuidhuif", "jksfbduhfudf shudf"));

		};
	}

}
