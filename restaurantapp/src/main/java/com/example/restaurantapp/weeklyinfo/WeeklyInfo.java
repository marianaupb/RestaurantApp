package com.example.restaurantapp.weeklyinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.restaurantapp.booking.Booking;
import com.example.restaurantapp.chefinfo.ChefInfo;
import com.example.restaurantapp.comments.Comment;
import com.example.restaurantapp.recipe.Recipe;

@Entity
public class WeeklyInfo {

	@Id  //creating id column of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates PK for every new entity
	private long idWeeklyInfo;
	
	//connecting with other columns
	@OneToOne(mappedBy = "weeklyInfo")
	private Recipe recipe;

	//connecting with other columns
	@ManyToOne
	@JoinColumn(name = "idChef", nullable = false)
	private ChefInfo chefInfo;
	
	@OneToMany (mappedBy = "weeklyInfo")
	private Set<Booking> booking;
	
	@OneToMany(mappedBy = "weeklyInfo")
	private Set<Comment> comment;
	
	@DateTimeFormat(iso=ISO.DATE) //it allows the system to get only date "new Date()"
	private Date date;
	
	@Column(length=5000)
	private String menu;
	
	
	public WeeklyInfo(Date date, String menu, ChefInfo chefInfo) {
		super();
		
		this.date = date;
		this.menu = menu;
		this.chefInfo = chefInfo;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	public WeeklyInfo() {

	}

	public long getIdWeeklyInfo() {
		return idWeeklyInfo;
	}


	public void setIdWeeklyInfo(long idWeeklyInfo) {
		this.idWeeklyInfo = idWeeklyInfo;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMenu() {
		return menu;
	}


	public void setMenu(String menu) {
		this.menu = menu;
	}


	public ChefInfo getChefInfo() {
		return chefInfo;
	}


	public void setChefInfo(ChefInfo chefInfo) {
		this.chefInfo = chefInfo;
	}


	public Set<Comment> getComment() {
		return comment;
	}


	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	/**
	 * @return the current week of the year only
	 */
	public Integer getWeek()	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate());
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
}