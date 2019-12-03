package com.example.restaurantapp.chefinfo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;

@Entity
public class ChefInfo {
	// Info related to the Chef per week

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idChef; // Automatic ID number

	@OneToMany(mappedBy = "chefInfo")
	private Set<WeeklyInfo> weeklyInfo;

	private String chefName;

	@Column(length = 3000) // Allow long String description
	private String chefDescription;

	public ChefInfo() {

	}

	public ChefInfo(String chefName, String chefDescription) {
		super();
		this.chefName = chefName;
		this.chefDescription = chefDescription;
	}

	public long getIdChef() {
		return idChef;
	}

	public void setIdChef(long idChef) {
		this.idChef = idChef;
	}

	public Set<WeeklyInfo> getWeeklyInfo() {
		return weeklyInfo;
	}

	public void setWeeklyInfo(Set<WeeklyInfo> weeklyInfo) {
		this.weeklyInfo = weeklyInfo;
	}

	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public String getChefDescription() {
		return chefDescription;
	}

	public void setChefDescription(String chefDescription) {
		this.chefDescription = chefDescription;
	}

}
