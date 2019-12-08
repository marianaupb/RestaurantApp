package com.example.restaurantapp.comments;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.restaurantapp.weeklyinfo.WeeklyInfo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idComment;

	@ManyToOne
	@JoinColumn(name = "idWeeklyInfo", nullable = false)
	private WeeklyInfo weeklyInfo;
	private Date date;
	private String name;
	private String email;

	@Column(length = 600)
	private String commentDescription;
	private int rating;

	public Comment() {

	}

	public Comment(Date date, String name, String email, String commentDescription, int rating, WeeklyInfo weeklyInfo) {
		super();
		this.date = date;
		this.name = name;
		this.email = email;
		this.commentDescription = commentDescription;
		this.rating = rating;
		this.weeklyInfo = weeklyInfo;
	}

	public long getIdComment() {
		return idComment;
	}

	public void setIdComment(long idComment) {
		this.idComment = idComment;
	}

	public WeeklyInfo getWeeklyInfo() {
		return weeklyInfo;
	}

	public void setWeeklyInfo(WeeklyInfo weeklyInfo) {
		this.weeklyInfo = weeklyInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
