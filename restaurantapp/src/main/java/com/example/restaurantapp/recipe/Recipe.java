package com.example.restaurantapp.recipe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;

@Entity
public class Recipe {
	//Weekly recipe data comes here

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idRecipe;
	
	@OneToOne
	@JoinColumn(name = "idWeeklyInfo")
	private WeeklyInfo weeklyInfo;

	private Date date;
	private String chef;
	private String title;
	@Column(length=3000)
	private String ingredients;
	@Column(length=6000)
	private String howToCook;

	public Recipe() {
	}

	public Recipe(Date date, String chef, String title, String ingredients, String howToCook) {
		super();
		this.date = date;
		this.chef = chef;
		this.title = title;
		this.ingredients = ingredients;
		this.howToCook = howToCook;
	}

	public String getHowToCook() {
		return howToCook;
	}

	public void setHowToCook(String howToCook) {
		this.howToCook = howToCook;
	}

	public long getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(long idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}



}
