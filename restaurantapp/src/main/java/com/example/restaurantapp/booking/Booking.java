package com.example.restaurantapp.booking;

import java.util.Date;

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

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBooking;
	
	@ManyToOne
	@JoinColumn(name = "idWeeklyInfo", nullable = false)
	private WeeklyInfo weeklyInfo;

	@DateTimeFormat(iso=ISO.DATE) //it allows the system to get only date "new Date()"
	private Date reservationDate;
	private String name;
	private String email;
	private long telephone;
	private int numberOfPeople;

	public Booking() {
	}

	public Booking(Date reservationDate, String name, String email, long telephone, int numberOfPeople, WeeklyInfo weeklyInfo) {
		super();
		this.reservationDate = reservationDate;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.numberOfPeople = numberOfPeople;
		this.weeklyInfo = weeklyInfo;
	}

	public Booking(WeeklyInfo weeklyInfo) {
		super();
		this.weeklyInfo = weeklyInfo;
	}

	public long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(long idBooking) {
		this.idBooking = idBooking;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public WeeklyInfo getWeeklyInfo() {
		return weeklyInfo;
	}

	public void setWeeklyInfo(WeeklyInfo weeklyInfo) {
		this.weeklyInfo = weeklyInfo;
	}
	

}
