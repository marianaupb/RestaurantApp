package com.example.restaurantapp.recipe;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // needs to change from AUTO in the future
	private long id;

	@OneToOne
	private WeeklyInfo weeklyInfo;

	private Date date;
	private String chef;
	private String title;
	private String ingredients;

	public Recipe() {
	}

	public Recipe(WeeklyInfo weeklyInfo, Date date, String chef, String title, String ingredients, byte[] image) {
		super();
		this.weeklyInfo = weeklyInfo;
		this.date = date;
		this.chef = chef;
		this.title = title;
		this.ingredients = ingredients;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	private byte[] image;

}
